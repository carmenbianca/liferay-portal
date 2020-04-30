/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.xstream.configurator;

import com.liferay.exportimport.kernel.xstream.XStreamAlias;
import com.liferay.exportimport.kernel.xstream.XStreamConverter;
import com.liferay.exportimport.kernel.xstream.XStreamType;

import java.util.List;

/**
 * @author Máté Thurzó
 */
public interface XStreamConfigurator {

	public List<XStreamType> getAllowedXStreamTypes();

	public List<XStreamAlias> getXStreamAliases();

	public List<XStreamConverter> getXStreamConverters();

}