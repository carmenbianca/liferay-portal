/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';

export default function getLayoutDataItemPropTypes(extraPropTypes = {}) {
	return PropTypes.shape({
		children: PropTypes.arrayOf(PropTypes.string).isRequired,
		config: PropTypes.object,
		itemId: PropTypes.string.isRequired,
		parentId: PropTypes.string.isRequired,
		type: PropTypes.string.isRequired,
		...extraPropTypes,
	});
}
