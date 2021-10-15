package cn.wegrowth.gateway.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource
import org.springframework.web.util.pattern.PathPatternParser


@Configuration
class CorsConfig {
    @Bean
    fun corsFilter(): CorsWebFilter = CorsConfiguration().run {
        addAllowedMethod("*")
        addAllowedOrigin("*")
        addAllowedHeader("*")
        val source = UrlBasedCorsConfigurationSource(PathPatternParser())
        source.registerCorsConfiguration("/**", this)
        return CorsWebFilter(source)
    }

}
