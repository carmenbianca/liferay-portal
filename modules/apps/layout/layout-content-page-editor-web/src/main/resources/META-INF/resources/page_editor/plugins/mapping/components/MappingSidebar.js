/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {config} from '../../../app/config/index';
import SidebarPanelContent from '../../../common/components/SidebarPanelContent';
import SidebarPanelHeader from '../../../common/components/SidebarPanelHeader';

export default function MappingSidebar() {
	return (
		<>
			<SidebarPanelHeader>
				{Liferay.Language.get('mapping')}
			</SidebarPanelHeader>

			<SidebarPanelContent>
				<p className="mb-4 small text-secondary">
					{Liferay.Language.get(
						'content-source-selected-for-this-display-page-template'
					)}
				</p>

				<div className="d-flex flex-column mb-4">
					<p className="list-group-title">
						{Liferay.Language.get('content-type')}:
					</p>
					<p className="mb-0 small">
						{config.selectedMappingTypes.type.label}
					</p>
				</div>

				{config.selectedMappingTypes.subtype && (
					<div className="d-flex flex-column">
						<p className="list-group-title">
							{Liferay.Language.get('subtype')}:
						</p>
						<p className="small">
							{config.selectedMappingTypes.subtype.label}
						</p>
					</div>
				)}
			</SidebarPanelContent>
		</>
	);
}
