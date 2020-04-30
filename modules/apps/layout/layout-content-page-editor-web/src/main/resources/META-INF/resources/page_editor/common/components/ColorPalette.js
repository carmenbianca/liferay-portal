/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import classNames from 'classnames';
import PropTypes from 'prop-types';
import React from 'react';

import {config} from '../../app/config/index';

export default function ColorPalette({
	label,
	onClear,
	onColorSelect,
	selectedColor,
}) {
	return (
		<>
			{label && <label htmlFor="colorPalette">{label}</label>}

			<div className="palette-container" id="colorPalette">
				<ul className="list-unstyled palette-items-container">
					{config.themeColorsCssClasses.map(color => (
						<li
							className={classNames('palette-item', {
								'palette-item-selected':
									color === selectedColor,
							})}
							key={color}
						>
							<ClayButton
								block
								className={classNames(
									`bg-${color}`,
									'palette-item-inner',
									'p-1',
									'rounded-circle'
								)}
								displayType="unstyled"
								onClick={event => onColorSelect(color, event)}
								small
							/>
						</li>
					))}
				</ul>
			</div>

			{onClear && (
				<ClayButton displayType="secondary" onClick={onClear} small>
					{Liferay.Language.get('clear')}
				</ClayButton>
			)}
		</>
	);
}

ColorPalette.propTypes = {
	label: PropTypes.string,
	onClear: PropTypes.func,
	onColorSelect: PropTypes.func.isRequired,
	selectedColor: PropTypes.string,
};
