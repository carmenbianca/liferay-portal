/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.soy.data;

import com.liferay.portal.template.soy.util.SoyRawData;

/**
 * Objects of this type contain sanitized HTML suitable for its use in Soy
 * templates.
 *
 * Use the {@link SoyDataFactory} OSGi service to create objects of this class.
 *
 * @author     Iván Zaera Avellón
 * @deprecated As of Mueller (7.2.x), , replaced by {@link SoyRawData}
 * @review
 */
@Deprecated
public interface SoyHTMLData extends SoyRawData {
}