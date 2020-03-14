package com.junenatte.nacosclient;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

public class TestClient {
    public static void main(String[] args) {
        String dataId="server01.yaml";
        String group="DEFAULT_GROUP";
        String url="127.0.0.1:8848";
        String namespace="e59d4b11-e738-41c1-a38c-f909504e5dff";
        try {
//            ConfigService configService= NacosFactory.createConfigService(url);
            Properties properties=new Properties();
            properties.setProperty("serverAddr",url);
            properties.setProperty("namespace",namespace);
            ConfigService configService=NacosFactory.createConfigService(properties);
            String content=configService.getConfig(dataId,group,5000);
            System.out.println(content);
            configService.addListener(dataId, group, new Listener() {
                @Override
                public Executor getExecutor() {
                    return null;
                }

                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println(configInfo);
                }
            });
            while(true){
                Thread.sleep(1000);
            }
        } catch (NacosException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
