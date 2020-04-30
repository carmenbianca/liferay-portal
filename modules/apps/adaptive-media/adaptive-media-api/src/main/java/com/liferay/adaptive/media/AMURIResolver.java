/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media;

import java.net.URI;

/**
 * @author Adolfo Pérez
 */
public interface AMURIResolver {

	public URI resolveURI(URI relativeURI);

}