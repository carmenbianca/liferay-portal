/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/* eslint-disable prefer-arrow-callback */
AUI().ready('liferay-sign-in-modal', function(A) {
	var signIn = A.one('.sign-in > a');

	if (signIn && signIn.getData('redirect') !== 'true') {
		signIn.plug(Liferay.SignInModal);
	}
});
