package com.dream.admin.service.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>Title:      RandomConfig. </p>
 * <p>Description 随机数 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/11/16 14:07
 */
@Component
public class RandomConfig {

    @Value("${dream.random.randomStr}")
    private String randomStr;

    @Value("${dream.random.randomInt}")
    private int randomInt;

    @Value("${dream.random.randomLong}")
    private long randomLong;

    @Value("${dream.random.random10}")
    private int random10;

    @Value("${dream.random.random10_20}")
    private int random10_20;

    public String getRandomStr() {
        return randomStr;
    }

    public void setRandomStr(String randomStr) {
        this.randomStr = randomStr;
    }

    public int getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(int randomInt) {
        this.randomInt = randomInt;
    }

    public long getRandomLong() {
        return randomLong;
    }

    public void setRandomLong(long randomLong) {
        this.randomLong = randomLong;
    }

    public int getRandom10() {
        return random10;
    }

    public void setRandom10(int random10) {
        this.random10 = random10;
    }

    public int getRandom10_20() {
        return random10_20;
    }

    public void setRandom10_20(int random10_20) {
        this.random10_20 = random10_20;
    }
}
