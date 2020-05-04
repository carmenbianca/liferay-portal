/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.internal.processor;

import com.liferay.adaptive.media.AMAttribute;
import com.liferay.adaptive.media.AdaptiveMedia;
import com.liferay.adaptive.media.image.internal.configuration.AMImageAttributeMapping;
import com.liferay.adaptive.media.image.processor.AMImageProcessor;

import java.io.InputStream;

import java.net.URI;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Adolfo Pérez
 */
public final class AMImage implements AdaptiveMedia<AMImageProcessor> {

	public AMImage(
		Supplier<InputStream> supplier,
		AMImageAttributeMapping amImageAttributeMapping, URI uri) {

		_supplier = supplier;
		_amImageAttributeMapping = amImageAttributeMapping;
		_uri = uri;
	}

	@Override
	public InputStream getInputStream() {
		return _supplier.get();
	}

	@Override
	public URI getURI() {
		return _uri;
	}

	@Override
	public <V> Optional<V> getValueOptional(
		AMAttribute<AMImageProcessor, V> amAttribute) {

		return _amImageAttributeMapping.getValueOptional(amAttribute);
	}

	private final AMImageAttributeMapping _amImageAttributeMapping;
	private final Supplier<InputStream> _supplier;
	private final URI _uri;

}