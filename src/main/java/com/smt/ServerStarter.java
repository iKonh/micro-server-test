package com.smt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Huangyipeng on 2015/10/09.
 */
@SpringBootApplication
public class ServerStarter {

    /**
     * アプリケーションを開始します。<br>
     * @param args 起動引数
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerStarter.class, args);
    }
}
