/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';
import {Link} from 'react-router-dom';

import {stringToSlug} from '../utils/utils.es';

export default props => {
	return <Link {...props} to={stringToSlug(props.to)} />;
};
