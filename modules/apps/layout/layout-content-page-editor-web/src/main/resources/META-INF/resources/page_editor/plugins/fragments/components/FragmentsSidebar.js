/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useMemo, useState} from 'react';

import {useSelector} from '../../../app/store/index';
import Collapse from '../../../common/components/Collapse';
import SearchForm from '../../../common/components/SearchForm';
import SidebarPanelContent from '../../../common/components/SidebarPanelContent';
import SidebarPanelHeader from '../../../common/components/SidebarPanelHeader';
import CollectionDisplay from './CollectionDisplay';
import FragmentCard from './FragmentCard';
import LayoutElements from './LayoutElements';

export default function FragmentsSidebar() {
	const fragments = useSelector(state => state.fragments);

	const [searchValue, setSearchValue] = useState('');

	const filteredFragments = useMemo(() => {
		const searchValueLowerCase = searchValue.toLowerCase();

		return searchValue
			? fragments
					.map(fragmentCollection => {
						return {
							...fragmentCollection,
							fragmentEntries: fragmentCollection.fragmentEntries.filter(
								fragmentEntry =>
									fragmentEntry.name
										.toLowerCase()
										.indexOf(searchValueLowerCase) !== -1
							),
						};
					})
					.filter(fragmentCollection => {
						return fragmentCollection.fragmentEntries.length > 0;
					})
			: fragments;
	}, [fragments, searchValue]);

	return (
		<>
			<SidebarPanelHeader>
				{Liferay.Language.get('fragments')}
			</SidebarPanelHeader>

			<SidebarPanelContent>
				<SearchForm onChange={setSearchValue} value={searchValue} />

				{!searchValue.length && <LayoutElements />}

				{filteredFragments.map(fragmentCollection => (
					<div key={fragmentCollection.fragmentCollectionId}>
						<Collapse
							label={fragmentCollection.name}
							open={searchValue.length > 0}
						>
							<div className="align-items-start d-flex flex-wrap justify-content-between">
								{fragmentCollection.fragmentEntries.map(
									fragmentEntry => (
										<FragmentCard
											fragmentEntryKey={
												fragmentEntry.fragmentEntryKey
											}
											groupId={fragmentEntry.groupId}
											imagePreviewURL={
												fragmentEntry.imagePreviewURL
											}
											key={fragmentEntry.fragmentEntryKey}
											name={fragmentEntry.name}
											type={fragmentEntry.type}
										/>
									)
								)}
							</div>
						</Collapse>
					</div>
				))}

				{!searchValue.length && <CollectionDisplay />}
			</SidebarPanelContent>
		</>
	);
}
