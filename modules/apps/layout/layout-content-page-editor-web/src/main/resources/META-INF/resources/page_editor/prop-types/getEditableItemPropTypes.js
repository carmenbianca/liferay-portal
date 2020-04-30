/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';

import {EDITABLE_TYPES} from '../app/config/constants/editableTypes';

export default function getEditableItemPropTypes(extraPropTypes = {}) {
	return PropTypes.shape({
		editableId: PropTypes.string.isRequired,
		editableType: PropTypes.oneOf(Object.values(EDITABLE_TYPES)),
		fragmentEntryLinkId: PropTypes.string.isRequired,
		itemId: PropTypes.string.isRequired,
		...extraPropTypes,
	});
}
