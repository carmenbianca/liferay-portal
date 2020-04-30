/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {openToast} from 'frontend-js-web';

export const errorToast = (
	message = Liferay.Language.get('an-unexpected-error-occurred'),
	title = Liferay.Language.get('error')
) => {
	openToast({
		message,
		title: `${title}:`,
		type: 'danger',
	});
};
