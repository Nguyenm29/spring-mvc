package com.laptrinhjavaweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;

public class JpaAuditingConfig {

	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}

	public static class AuditorAwareImpl implements AuditorAware<String> {

		@Override
		public String getCurrentAuditor() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null) {
				return null;
			}
			return authentication.getName();
		}
	}
}
