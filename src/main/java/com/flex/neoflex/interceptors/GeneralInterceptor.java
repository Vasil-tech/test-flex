package com.flex.neoflex.interceptors;

import com.flex.neoflex.controllers.RegController;
import com.flex.neoflex.models.ProfileRequest;
import jakarta.persistence.Enumerated;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

@Component
public class GeneralInterceptor implements HandlerInterceptor {
	private final RegController regController;
	private Logger LOG = LoggerFactory.getLogger(GeneralInterceptor.class);

	public GeneralInterceptor(RegController regController) {
		this.regController = regController;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		HttpHeaders headers = new HttpHeaders();
//		Enumeration<String> headerNames = request.getHeaderNames();
//		if(headerNames != null){
//			while(headerNames.hasMoreElements()){
//				String name = headerNames.nextElement();
//				headers.add(name, request.getHeader(name));
//				LOG.info("Заголовок " + request.getHeader(name));
//			}
//		}
//		String customHeader = request.getHeader("Custom-Header");
//	LOG.info("Заголовок " + customHeader);
//		// Валидация заголовка
//		if (customHeader == null || !customHeader.equals("ExpectedValue")) {
//			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Установка статуса ответа как 400 Bad Request
//			return false; // Прекращение обработки запроса
//		}
//
//		return true; // Продолжение обработки запроса

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		///рабочий вариант
//		InputStream inputStream = request.getInputStream();
//		// Создаем BufferedReader для удобства чтения
//		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//		// Читаем данные из потока
//		StringBuilder sb = new StringBuilder();
//		String line;
//		while ((line = reader.readLine()) != null) {
//			sb.append(line);
//		}
//
//		// Закрываем ресурсы
//		reader.close();
//		inputStream.close();


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		List<String> responsebode = new ArrayList<>();
//		// Теперь у вас есть тело запроса в виде строки
//		while(sb != null){
//			responsebode.add(sb.toString());
//			LOG.info("Заголовки " + responsebode);
//			if(responsebode.size() > 1)
//			{break;}
//
//		}
//		String requestBody = sb.toString();
//		String[] words = requestBody.split(", ");
//
//		String word = words.toString();
//		String[] words2 = word.split(": ");
////		while(words != null) {
////			LOG.info("Заголовки " + words);
////		}
//		for(String str : words2){
//			LOG.info("Заголовки " + str);
//		}
//		// Валидация заголовка
//		if (requestBody == null || !requestBody.equals("")) {
//			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Установка статуса ответа как 400 Bad Request
//			return false; // Прекращение обработки запроса
//		}
 		return true;
	}
}
