/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.friendly.url.internal.xstream.configurator;

import com.liferay.exportimport.kernel.xstream.XStreamAlias;
import com.liferay.exportimport.kernel.xstream.XStreamConverter;
import com.liferay.exportimport.kernel.xstream.XStreamType;
import com.liferay.friendly.url.model.impl.FriendlyURLEntryImpl;
import com.liferay.xstream.configurator.XStreamConfigurator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 */
@Component(immediate = true, service = XStreamConfigurator.class)
public class FriendlyURLEntryXStreamConfigurator
	implements XStreamConfigurator {

	@Override
	public List<XStreamType> getAllowedXStreamTypes() {
		return _xStreamTypes;
	}

	@Override
	public List<XStreamAlias> getXStreamAliases() {
		return _xStreamAliases;
	}

	@Override
	public List<XStreamConverter> getXStreamConverters() {
		return Collections.emptyList();
	}

	private final List<XStreamAlias> _xStreamAliases = Arrays.asList(
		new XStreamAlias(FriendlyURLEntryImpl.class, "FriendlyURLEntry"));
	private final List<XStreamType> _xStreamTypes = Arrays.asList(
		new XStreamType(FriendlyURLEntryImpl.class));

}