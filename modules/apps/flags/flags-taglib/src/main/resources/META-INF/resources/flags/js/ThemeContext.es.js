/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';
import React from 'react';

const ThemeContext = React.createContext({
	namespace: '',
});

ThemeContext.Provider.propTypes = {
	value: PropTypes.shape({
		namespace: PropTypes.string,
	}),
};

export default ThemeContext;
