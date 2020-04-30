/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayButtonWithIcon} from '@clayui/button';
import {ClayInput} from '@clayui/form';
import ClayManagementToolbar from '@clayui/management-toolbar';
import React, {useEffect, useState} from 'react';

export default ({
	onSubmit,
	searchText = '',
	setShowMobile,
	showMobile,
	...restProps
}) => {
	const [value, setValue] = useState(searchText);

	useEffect(() => {
		setValue(searchText);
	}, [searchText]);

	return (
		<ClayManagementToolbar.Search
			onSubmit={event => {
				event.preventDefault();
				onSubmit(value.trim());
			}}
			showMobile={showMobile}
		>
			<ClayInput.Group>
				<ClayInput.GroupItem>
					<ClayInput
						aria-label={Liferay.Language.get('search')}
						className="input-group-inset input-group-inset-after"
						onChange={({target: {value}}) => setValue(value)}
						placeholder={`${Liferay.Language.get('search')}...`}
						type="text"
						value={value}
						{...restProps}
					/>

					<ClayInput.GroupInsetItem after tag="span">
						<ClayButtonWithIcon
							className="navbar-breakpoint-d-none"
							displayType="unstyled"
							onClick={() => setShowMobile(false)}
							symbol="times"
						/>
						<ClayButtonWithIcon
							displayType="unstyled"
							symbol="search"
							type="submit"
						/>
					</ClayInput.GroupInsetItem>
				</ClayInput.GroupItem>
			</ClayInput.Group>
		</ClayManagementToolbar.Search>
	);
};
