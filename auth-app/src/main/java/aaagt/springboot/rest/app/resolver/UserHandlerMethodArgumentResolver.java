package aaagt.springboot.rest.app.resolver;

import aaagt.springboot.rest.app.exception.InvalidCredentials;
import aaagt.springboot.rest.app.model.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParam, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {

        final var username = webRequest.getParameter("user");
        final var password = webRequest.getParameter("password");
        if (isEmpty(username) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        final var user = new User(username, password);
        return user;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
