/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayColorPicker from '@clayui/color-picker';
import React, {useState} from 'react';

function normalizeColor(color) {
	return color.startsWith('#') ? color.substring(1) : color;
}

const ColorPicker = ({color, label, name}) => {
	const [colorValue, setColorValue] = useState(normalizeColor(color));

	return (
		<div className="form-group">
			<input name={name} type="hidden" value={`#${colorValue}`} />

			<ClayColorPicker
				label={label}
				name={`${name}ColorPicker`}
				onValueChange={setColorValue}
				showHex={true}
				title={label}
				value={colorValue}
			/>
		</div>
	);
};

export default ColorPicker;
