/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.captcha.internal.configuration.persistence.listener;

import com.liferay.captcha.configuration.CaptchaConfiguration;
import com.liferay.captcha.recaptcha.ReCaptchaImpl;
import com.liferay.portal.configuration.persistence.listener.ConfigurationModelListener;
import com.liferay.portal.configuration.persistence.listener.ConfigurationModelListenerException;
import com.liferay.portal.kernel.captcha.CaptchaConfigurationException;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Dictionary;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pei-Jung Lan
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.captcha.configuration.CaptchaConfiguration",
	service = ConfigurationModelListener.class
)
public class CaptchaConfigurationModelListener
	implements ConfigurationModelListener {

	@Override
	public void onBeforeSave(String pid, Dictionary<String, Object> properties)
		throws ConfigurationModelListenerException {

		try {
			String captchaEngine = (String)properties.get("captchaEngine");

			if (Validator.isNotNull(captchaEngine) &&
				captchaEngine.equals(ReCaptchaImpl.class.getName())) {

				validateReCaptchaKeys(properties);
			}
		}
		catch (CaptchaConfigurationException captchaConfigurationException) {
			throw new ConfigurationModelListenerException(
				captchaConfigurationException.getMessage(),
				CaptchaConfiguration.class,
				CaptchaConfigurationModelListener.class, properties);
		}
	}

	protected ResourceBundle getResourceBundle() {
		if (_resourceBundle == null) {
			Locale locale = LocaleThreadLocal.getThemeDisplayLocale();

			return ResourceBundleUtil.getBundle(
				"content.Language", locale, getClass());
		}

		return _resourceBundle;
	}

	protected void validateReCaptchaKeys(Dictionary<String, Object> properties)
		throws CaptchaConfigurationException {

		String reCaptchaPublicKey = (String)properties.get(
			"reCaptchaPublicKey");
		String reCaptchaPrivateKey = (String)properties.get(
			"reCaptchaPrivateKey");

		if (Validator.isNull(reCaptchaPublicKey)) {
			throw new CaptchaConfigurationException(
				ResourceBundleUtil.getString(
					getResourceBundle(),
					"the-recaptcha-public-key-is-not-valid"));
		}

		if (Validator.isNull(reCaptchaPrivateKey)) {
			throw new CaptchaConfigurationException(
				ResourceBundleUtil.getString(
					getResourceBundle(),
					"the-recaptcha-private-key-is-not-valid"));
		}
	}

	private ResourceBundle _resourceBundle;

}