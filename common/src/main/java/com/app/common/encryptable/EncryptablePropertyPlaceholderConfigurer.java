package com.app.common.encryptable;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


/**
 * 重新
 * 
 * @author lt
 */
public class EncryptablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private String key;

	public EncryptablePropertyPlaceholderConfigurer(String key) {
		this.key = key;
	}

	@Override
	@SuppressWarnings("all")
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		try {
			String driverClass = props.getProperty("jdbc.driverClass");
			if (driverClass != null) {
				props.setProperty("jdbc.driverClass",
						new String(Aes.decrypt(Aes.parseHexStr2Byte(driverClass), key)));
			}
			String url = props.getProperty("jdbc.url");
			if (url != null) {
				props.setProperty("jdbc.url", new String(Aes.decrypt(Aes.parseHexStr2Byte(url), key)));
			}
			String username = props.getProperty("jdbc.username");
			if (username != null) {
				props.setProperty("jdbc.username", new String(Aes.decrypt(Aes.parseHexStr2Byte(username), key)));
			}
			String password = props.getProperty("jdbc.password");
			if (password != null) {
				props.setProperty("jdbc.password", new String(Aes.decrypt(Aes.parseHexStr2Byte(password), key)));
			}

			super.processProperties(beanFactory, props);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
