/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

class FormURL {
	constructor(
		formInstanceId,
		published = false,
		requireAuthentication = false
	) {
		this.formInstanceId = formInstanceId;
		this.published = published;
		this.requireAuthentication = requireAuthentication;
	}

	create() {
		if (!this.published) {
			return '';
		}

		let formURL;

		if (this.requireAuthentication) {
			formURL = Liferay.DDM.FormSettings.restrictedFormURL;
		}
		else {
			formURL = Liferay.DDM.FormSettings.sharedFormURL;
		}

		return formURL + this.formInstanceId;
	}
}

export default FormURL;
