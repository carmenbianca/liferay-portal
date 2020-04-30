/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';

const ConfigurationFieldPropTypes = {
	dataType: PropTypes.string,
	defaultValue: PropTypes.oneOfType([PropTypes.bool, PropTypes.string]),
	description: PropTypes.string,
	label: PropTypes.string,
	name: PropTypes.string.isRequired,
	type: PropTypes.string,
};

export default ConfigurationFieldPropTypes;
