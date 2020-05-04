/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template;

import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateResource;

import java.io.Writer;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author     Tina Tian
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public class RestrictedTemplate implements Template {

	public RestrictedTemplate(
		Template template, Set<String> restrictedVariables) {

		_template = template;
		_restrictedVariables = restrictedVariables;
	}

	@Override
	public void clear() {
		_template.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return _template.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return _template.containsValue(value);
	}

	@Override
	public Set<Entry<String, Object>> entrySet() {
		return _template.entrySet();
	}

	@Override
	public Object get(Object key) {
		return _template.get(key);
	}

	@Override
	public boolean isEmpty() {
		return _template.isEmpty();
	}

	@Override
	public Set<String> keySet() {
		return _template.keySet();
	}

	@Override
	public void prepare(HttpServletRequest httpServletRequest) {
		_template.prepare(httpServletRequest);
	}

	@Override
	public void prepareTaglib(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		_template.prepareTaglib(httpServletRequest, httpServletResponse);
	}

	@Override
	public void processTemplate(Writer writer) throws TemplateException {
		_template.processTemplate(writer);
	}

	@Override
	public void processTemplate(
			Writer writer,
			Supplier<TemplateResource> errorTemplateResourceSupplier)
		throws TemplateException {

		_template.processTemplate(writer, errorTemplateResourceSupplier);
	}

	@Override
	public Object put(String key, Object value) {
		if (_restrictedVariables.contains(key)) {
			return null;
		}

		return _template.put(key, value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		_template.putAll(m);
	}

	@Override
	public Object remove(Object key) {
		return _template.remove(key);
	}

	@Override
	public int size() {
		return _template.size();
	}

	@Override
	public Collection<Object> values() {
		return _template.values();
	}

	private final Set<String> _restrictedVariables;
	private final Template _template;

}