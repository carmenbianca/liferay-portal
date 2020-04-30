/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {updateField} from './fieldEditedHandler.es';

export const handleFieldBlurred = (state, event) => {
	const {propertyName, propertyValue} = event;
	let newState = {pages: state.pages};

	if (propertyName === 'name' && propertyValue === '') {
		newState = updateField(state, propertyName, propertyValue);
	}

	return newState;
};

export default handleFieldBlurred;
