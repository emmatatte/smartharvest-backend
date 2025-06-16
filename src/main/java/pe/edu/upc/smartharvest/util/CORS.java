package pe.edu.upc.smartharvest.util;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORS implements Filter {
	// Lista de orígenes permitidos
	private final List<String> allowedOrigins = Arrays.asList(
			"http://localhost:4200",                    // Desarrollo local
			"https://smartharvest-frontend.onrender.com" // Producción (cambiar por tu URL real)
	);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		}
		/*
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		String origin = request.getHeader("Origin");
		String method = request.getMethod();

		if (!"http://localhost:4200".equals(origin)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "Origin not allowed");
			return;
		}


		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		//response.setHeader("Access-Control-Allow-Methods", "DELETE, GET, OPTIONS, PATCH, POST, PUT");
		response.setHeader("Access-Control-Allow-Methods", "GET");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN");



		if ("OPTIONS".equalsIgnoreCase(method)) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else if (!"GET".equalsIgnoreCase(method)) {
			// Rechazar explícitamente métodos distintos de POST
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Only GET is allowed");
		} else {
			chain.doFilter(req, res);
		}

	}
	*/
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		String origin = request.getHeader("Origin");

		// Verificar si el origen está permitido
		if (origin != null && allowedOrigins.contains(origin)) {
			response.setHeader("Access-Control-Allow-Origin", origin);
		}

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "DELETE, GET, OPTIONS, PATCH, POST, PUT");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(req, res);
		}
		// chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}