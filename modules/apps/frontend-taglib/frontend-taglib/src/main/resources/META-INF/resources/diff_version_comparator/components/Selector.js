/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayDropDown from '@clayui/drop-down';
import ClayIcon from '@clayui/icon';
import React, {useState} from 'react';

export default function Selector({
	label,
	selectedVersion,
	uniqueVersionLabel,
	urlSelector,
	versions,
}) {
	const [active, setActive] = useState(false);

	return (
		<>
			{!versions.length ? (
				label
			) : (
				<div>
					<ClayDropDown
						active={active}
						onActiveChange={newVal => setActive(newVal)}
						trigger={
							<ClayButton displayType="unstyled">
								<span className="management-bar-item-title">
									{label}
								</span>

								<ClayIcon symbol="caret-double-l" />
							</ClayButton>
						}
					>
						<ClayDropDown.ItemList>
							{versions.map(version => (
								<ClayDropDown.Item
									href={version[urlSelector]}
									key={version.version}
								>
									{version.label}
								</ClayDropDown.Item>
							))}
						</ClayDropDown.ItemList>
					</ClayDropDown>
				</div>
			)}

			{selectedVersion === '0.0' && (
				<h6 className="text-default">{uniqueVersionLabel}</h6>
			)}
		</>
	);
}
