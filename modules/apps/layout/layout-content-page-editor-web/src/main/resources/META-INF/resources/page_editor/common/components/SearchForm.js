/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm, {ClayInput} from '@clayui/form';
import PropTypes from 'prop-types';
import React from 'react';

let nextInputId = 0;

export default function SearchForm({onChange, value}) {
	const id = `pageEditorSearchFormInput${nextInputId++}`;

	return (
		<ClayForm.Group className="mb-3" role="search">
			<label className="sr-only" htmlFor={id}>
				{Liferay.Language.get('search-form')}
			</label>
			<ClayInput
				id={id}
				onChange={event => {
					onChange(event.target.value);
				}}
				placeholder={`${Liferay.Language.get('search')}...`}
				sizing="sm"
				type="text"
				value={value}
			/>
		</ClayForm.Group>
	);
}

SearchForm.propTypes = {
	onChange: PropTypes.func.isRequired,
	value: PropTypes.string.isRequired,
};
