package com.mvp.mvpshop;

import org.junit.Test;

import static org.junit.Assert.*;

import com.mvp.mvpshop.bean.BaseBean;
import com.mvp.mvpshop.bean.Goods;
import com.mvp.mvpshop.network.RetrofitClient;
import com.mvp.mvpshop.network.service.GoodsService;

import java.util.List;

import io.reactivex.rxjava3.functions.Consumer;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {


        GoodsService goodsService = RetrofitClient.getInstance().getService(GoodsService.class);
        goodsService.getGoods().subscribe(new Consumer<BaseBean<List<Goods>>>() {
            @Override
            public void accept(BaseBean<List<Goods>> listBaseBean) throws Throwable {
                System.out.println("请求结果："+listBaseBean);
            }
        });

        while(true){}
    }
}