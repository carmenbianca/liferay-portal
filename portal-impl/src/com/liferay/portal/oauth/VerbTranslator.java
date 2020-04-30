/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.oauth;

import com.liferay.portal.kernel.oauth.Verb;

/**
 * @author Brian Wing Shun Chan
 */
public class VerbTranslator {

	public static Verb translate(org.scribe.model.Verb verb) {
		if (verb == org.scribe.model.Verb.DELETE) {
			return Verb.DELETE;
		}
		else if (verb == org.scribe.model.Verb.GET) {
			return Verb.GET;
		}
		else if (verb == org.scribe.model.Verb.POST) {
			return Verb.POST;
		}
		else if (verb == org.scribe.model.Verb.PUT) {
			return Verb.PUT;
		}
		else {
			throw new IllegalArgumentException("Unknown verb " + verb);
		}
	}

	public static org.scribe.model.Verb translate(Verb verb) {
		if (verb == Verb.DELETE) {
			return org.scribe.model.Verb.DELETE;
		}
		else if (verb == Verb.GET) {
			return org.scribe.model.Verb.GET;
		}
		else if (verb == Verb.POST) {
			return org.scribe.model.Verb.POST;
		}
		else if (verb == Verb.PUT) {
			return org.scribe.model.Verb.PUT;
		}
		else {
			throw new IllegalArgumentException("Unknown verb " + verb);
		}
	}

}