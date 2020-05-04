/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.velocity.internal;

import com.liferay.portal.kernel.io.ReaderInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.TemplateResourceLoader;
import com.liferay.portal.kernel.util.GetterUtil;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class LiferayResourceLoader extends ResourceLoader {

	@Override
	public long getLastModified(Resource resource) {
		if (_log.isDebugEnabled()) {
			_log.debug("Get last modified for " + resource.getName());
		}

		return 0;
	}

	@Override
	public InputStream getResourceStream(String source)
		throws ResourceNotFoundException {

		InputStream is = doGetResourceStream(source);

		if (is == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to find " + source);
			}

			throw new ResourceNotFoundException(source);
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Successfully found " + source);
		}

		return is;
	}

	@Override
	public void init(ExtendedProperties extendedProperties) {
		int resourceModificationCheckInterval = GetterUtil.getInteger(
			extendedProperties.get("resourceModificationCheckInterval"), 60);

		setModificationCheckInterval(resourceModificationCheckInterval);

		_templateResourceLoader =
			(TemplateResourceLoader)extendedProperties.get(
				VelocityTemplateResourceLoader.class.getName());
	}

	@Override
	public boolean isSourceModified(Resource resource) {
		if (_log.isDebugEnabled()) {
			_log.debug("Check modified status for " + resource.getName());
		}

		return false;
	}

	@Override
	public boolean resourceExists(String resourceName) {
		InputStream is = null;

		try {
			is = doGetResourceStream(resourceName);

			if (is != null) {
				is.close();
			}
		}
		catch (IOException ioException) {
		}
		catch (ResourceNotFoundException resourceNotFoundException) {
		}

		if (is != null) {
			return true;
		}

		return false;
	}

	protected InputStream doGetResourceStream(String source)
		throws ResourceNotFoundException {

		if (_log.isDebugEnabled()) {
			_log.debug("Get resource for " + source);
		}

		try {
			TemplateResource templateResource =
				_templateResourceLoader.getTemplateResource(source);

			return new ReaderInputStream(templateResource.getReader());
		}
		catch (Exception exception) {
			return null;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		LiferayResourceLoader.class);

	private TemplateResourceLoader _templateResourceLoader;

}