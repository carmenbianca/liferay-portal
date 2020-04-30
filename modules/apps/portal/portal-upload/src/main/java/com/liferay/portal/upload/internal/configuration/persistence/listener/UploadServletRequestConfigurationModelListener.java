/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upload.internal.configuration.persistence.listener;

import com.liferay.portal.configuration.persistence.listener.ConfigurationModelListener;
import com.liferay.portal.configuration.persistence.listener.ConfigurationModelListenerException;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.upload.UploadServletRequestImpl;
import com.liferay.portal.upload.internal.configuration.UploadServletRequestConfiguration;

import java.io.File;

import java.util.Dictionary;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pei-Jung Lan
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.portal.upload.internal.configuration.UploadServletRequestConfiguration",
	service = ConfigurationModelListener.class
)
public class UploadServletRequestConfigurationModelListener
	implements ConfigurationModelListener {

	@Override
	public void onAfterSave(String pid, Dictionary<String, Object> properties)
		throws ConfigurationModelListenerException {

		String tempDir = (String)properties.get("tempDir");

		if (Validator.isNull(tempDir)) {
			tempDir = SystemProperties.get(SystemProperties.TMP_DIR);
		}

		UploadServletRequestImpl.setTempDir(new File(tempDir));
	}

	@Override
	public void onBeforeSave(String pid, Dictionary<String, Object> properties)
		throws ConfigurationModelListenerException {

		String tempDir = (String)properties.get("tempDir");

		if (Validator.isNotNull(tempDir)) {
			File tempFile = new File(tempDir);

			if (!tempFile.exists()) {
				throw new ConfigurationModelListenerException(
					ResourceBundleUtil.getString(
						_getResourceBundle(),
						"please-enter-a-valid-temporary-storage-directory"),
					UploadServletRequestConfiguration.class, getClass(),
					properties);
			}
		}
	}

	private ResourceBundle _getResourceBundle() {
		return ResourceBundleUtil.getBundle(
			LocaleThreadLocal.getThemeDisplayLocale(), getClass());
	}

}