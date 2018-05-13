package com.listener;

import com.tool.HotSpot;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Amadeus on 2018/5/13.
 */
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web exit ... ");
    }

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web init ... ");
        //系统的初始化工作

        System.out.println("初始化热词获得器");
        HotSpot hotSpot = new HotSpot();
        hotSpot.initHotSpot();

    }
}