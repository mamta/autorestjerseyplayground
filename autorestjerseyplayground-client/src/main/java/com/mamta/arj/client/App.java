package com.mamta.arj.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.intendia.gwt.autorest.client.RequestResourceBuilder;
import com.intendia.gwt.autorest.client.ResourceVisitor;
import com.mamta.arj.client.api.AppService;
import com.mamta.arj.client.api.AppService_RestServiceModel;
import com.mamta.arj.client.api.UserInfoService;
import com.mamta.arj.client.api.UserInfoService_RestServiceModel;

import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    private static final String APP_SERVICE = "AppService";

    private static final String USER_INFO_SERVICE = "UserInfoService";

    @Override
    public void onModuleLoad() {

        AppService appService = new AppService_RestServiceModel(() -> getAppVisitor());

        appService.getGreeting().subscribe(consumer -> {
            logger.info("response: " + consumer.greeting);
            append("response: " + consumer.greeting);
        });

        UserInfoService userInfoService = new UserInfoService_RestServiceModel(() -> getUserInfoVisitor());

        userInfoService.getUserInfo().subscribe(consumer -> {

            logger.info("User " + consumer);
            // logger.info(consumer.getFirstName());
        });

    }

    private static void append(String text) {
        append(new Label(text));
    }

    private static <T extends IsWidget> T append(T w) {
        RootPanel.get().add(w);
        return w;
    }

    static ResourceVisitor getAppVisitor() {
        logger.info("app info " + GWT.getModuleBaseURL());
        return new RequestResourceBuilder().path("rest/" + APP_SERVICE).header("auth", "ok");
    }

    static ResourceVisitor getUserInfoVisitor() {
        logger.info("user info " + GWT.getModuleBaseURL());
        return new RequestResourceBuilder().path("rest/" + USER_INFO_SERVICE).header("auth", "ok");
    }

    public static <T> Observable<ValueChangeEvent<T>> valueChange(HasValueChangeHandlers<T> source) {
        return Observable.create(s -> register(s, source.addValueChangeHandler(s::onNext)));
    }

    private static void register(ObservableEmitter<?> s, HandlerRegistration handlerRegistration) {
        s.setCancellable(handlerRegistration::removeHandler);
    }
}
