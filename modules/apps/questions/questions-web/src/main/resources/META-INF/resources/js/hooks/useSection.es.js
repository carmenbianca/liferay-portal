/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useEffect, useState} from 'react';

import {getSection} from '../utils/client.es';

export default function useSection(sectionTitle, siteKey) {
	const [section, setSection] = useState({});

	useEffect(() => {
		getSection(sectionTitle, siteKey)
			.then(section => {
				if (section.parentMessageBoardSectionId) {
					return Promise.all([
						section,
						getSection(
							section.parentMessageBoardSectionId,
							siteKey
						),
					]);
				}

				return [section, section];
			})
			.then(([section, parentSection]) => {
				section.parentSection = parentSection;
				setSection(section);
			});
	}, [sectionTitle, siteKey]);

	return section;
}
