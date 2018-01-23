package com.dream.core.common.request;

import org.springframework.web.cors.CorsUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

/**
 * <p>Title:      UriMatchHandlerMapping. </p>
 * <p>Description 地址匹配 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/22 18:58
 */
public class UriMatchHandlerMapping {

    private final Map<RequestMappingInfo, HandlerMethod> mappingLookup = new LinkedHashMap<>();

    public UriMatchHandlerMapping(Map<RequestMappingInfo, HandlerMethod> mappingLookup) {
        this.mappingLookup.putAll(mappingLookup);
    }

    public Match lookupHandlerMethod(HttpServletRequest request) throws Exception {
        if (this.mappingLookup == null) {
            return null;
        }
        List<Match> matches = new ArrayList<>();
        if (matches.isEmpty()) {
            // No choice but to go through all mappings...
            addMatchingMappings(this.mappingLookup.keySet(), matches, request);
        }

        if (!matches.isEmpty()) {
            Comparator<Match> comparator = new MatchComparator(getMappingComparator(request));
            Collections.sort(matches, comparator);

            Match bestMatch = matches.get(0);
            if (matches.size() > 1) {
                if (CorsUtils.isPreFlightRequest(request)) {
                    throw new UnsupportedOperationException("not implemented");
                }
                Match secondBestMatch = matches.get(1);
                if (comparator.compare(bestMatch, secondBestMatch) == 0) {
                    Method m1 = bestMatch.handlerMethod.getMethod();
                    Method m2 = secondBestMatch.handlerMethod.getMethod();
                    throw new IllegalStateException("Ambiguous handler methods mapped for HTTP path '" +
                            request.getRequestURL() + "': {" + m1 + ", " + m2 + "}");
                }
            }
            return bestMatch;
        } else {
            return null;
        }
    }

    /**
     * <p>Title:      URIMatchHandlerMapper. </p>
     * <p>Description 排序的具体实现 </p>
     *
     * @author <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate 2018/1/22 18:52
     */
    private Comparator<RequestMappingInfo> getMappingComparator(final HttpServletRequest request) {
        return new Comparator<RequestMappingInfo>() {
            @Override
            public int compare(RequestMappingInfo info1, RequestMappingInfo info2) {
                return info1.compareTo(info2, request);
            }
        };
    }

    private void addMatchingMappings(Collection<RequestMappingInfo> mappings, List<Match> matches, HttpServletRequest request) {
        for (RequestMappingInfo mapping : mappings) {
            RequestMappingInfo match = mapping.getMatchingCondition(request);
            if (match != null) {
                matches.add(new Match(match, this.mappingLookup.get(mapping)));
            }
        }
    }

    public class Match {

        private final RequestMappingInfo mapping;

        private final HandlerMethod handlerMethod;

        public Match(RequestMappingInfo mapping, HandlerMethod handlerMethod) {
            this.mapping = mapping;
            this.handlerMethod = handlerMethod;
        }

        @Override
        public String toString() {
            return this.mapping.toString();
        }
    }


    /**
     * <p>Title:      URIMatchHandlerMapper. </p>
     * <p>Description 排序规则 </p>
     *
     * @author <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate 2018/1/22 18:52
     */
    private class MatchComparator implements Comparator<Match> {

        private final Comparator<RequestMappingInfo> comparator;

        public MatchComparator(Comparator<RequestMappingInfo> comparator) {
            this.comparator = comparator;
        }

        @Override
        public int compare(Match match1, Match match2) {
            return this.comparator.compare(match1.mapping, match2.mapping);
        }
    }
}

