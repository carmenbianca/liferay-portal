/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';

import getLayoutDataItemPropTypes from './getLayoutDataItemPropTypes';

const LayoutDataPropTypes = PropTypes.shape({
	items: PropTypes.objectOf(getLayoutDataItemPropTypes()),
	rootItems: PropTypes.shape({
		main: PropTypes.string,
	}),
	version: PropTypes.number,
});

export default LayoutDataPropTypes;
