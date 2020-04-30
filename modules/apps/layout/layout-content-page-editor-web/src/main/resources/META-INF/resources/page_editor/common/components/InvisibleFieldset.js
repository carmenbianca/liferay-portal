/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';
import React from 'react';

export default function InvisibleFieldset({children, disabled}) {
	return <fieldset disabled={disabled}>{children}</fieldset>;
}

InvisibleFieldset.propTypes = {
	children: PropTypes.node.isRequired,
	disabled: PropTypes.bool,
};
