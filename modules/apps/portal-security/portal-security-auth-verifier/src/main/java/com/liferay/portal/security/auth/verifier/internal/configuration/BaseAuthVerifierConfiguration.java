/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth.verifier.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Tomas Polesovsky
 */
public interface BaseAuthVerifierConfiguration {

	@Meta.AD(deflt = "true", name = "enabled", required = false)
	public boolean enabled();

	@Meta.AD(name = "hosts-allowed", required = false)
	public String hostsAllowed();

	@Meta.AD(name = "urls-excludes", required = false)
	public String urlsExcludes();

	@Meta.AD(name = "urls-includes", required = false)
	public String urlsIncludes();

}