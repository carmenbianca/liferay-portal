/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import PropTypes from 'prop-types';
import React from 'react';

import {getLayoutDataItemPropTypes} from '../../../prop-types/index';
import {LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS} from '../../config/constants/layoutDataItemDefaultConfigurations';
import {LAYOUT_DATA_ITEM_TYPES} from '../../config/constants/layoutDataItemTypes';

const Column = React.forwardRef(
	({children, className, item, ...props}, ref) => {
		const {
			config: {
				size = LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS[
					LAYOUT_DATA_ITEM_TYPES.column
				].size,
			},
		} = item;

		return (
			<div
				{...props}
				className={classNames(className, 'col', {
					[`col-${size}`]: size,
				})}
				ref={ref}
			>
				{children}
			</div>
		);
	}
);

Column.propTypes = {
	item: getLayoutDataItemPropTypes({
		config: PropTypes.shape({size: PropTypes.number}),
	}).isRequired,
};

export default Column;
