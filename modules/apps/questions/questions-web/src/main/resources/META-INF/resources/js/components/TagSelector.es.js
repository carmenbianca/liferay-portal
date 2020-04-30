/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm from '@clayui/form';
import ClayMultiSelect from '@clayui/multi-select';
import React, {useContext, useEffect, useState} from 'react';

import {AppContext} from '../AppContext.es';
import {getAllTags} from '../utils/client.es';

export default ({tagsChange, tagsLoaded, tags = [], ...props}) => {
	const context = useContext(AppContext);

	const [error, setError] = useState(false);
	const [inputValue, setInputValue] = useState('');
	const [items, setItems] = useState([]);
	const [sourceItems, setSourceItems] = useState([]);

	useEffect(() => {
		getAllTags(context.siteKey).then(data => {
			setSourceItems(
				data.items.map(({name}) => ({
					label: name,
					value: name,
				}))
			);
		});
	}, [context.siteKey]);

	useEffect(() => {
		if (tags.length) {
			setItems(tags);
		}
	}, [tags]);

	useEffect(() => {
		if (inputValue) {
			tagsLoaded(false);
		}
		else {
			tagsLoaded(true);
		}
	}, [inputValue, tagsLoaded]);

	const maxTags = tags => tags.length > 5;
	const duplicatedTags = tags =>
		new Set(tags.map(tag => tag.value)).size !== tags.length;

	const filterItems = tags => {
		if (!maxTags(tags) && !duplicatedTags(tags)) {
			setError(false);
			setItems(tags);
			tagsChange(tags);
		}
		else {
			setError(true);
		}
	};

	return (
		<>
			<ClayForm.Group className="c-mt-4">
				<label htmlFor="basicInput">
					{Liferay.Language.get('tags')}
				</label>
				<ClayMultiSelect
					{...props}
					inputValue={inputValue}
					items={items}
					onChange={setInputValue}
					onItemsChange={filterItems}
					sourceItems={sourceItems}
				/>
				<ClayForm.FeedbackGroup className={error && 'has-error'}>
					<ClayForm.FeedbackItem>
						<span className="small text-secondary">
							{Liferay.Language.get(
								'add-up-to-5-tags-to-describe-what-your-question-is-about'
							)}
						</span>
					</ClayForm.FeedbackItem>
					{error && (
						<ClayForm.FeedbackItem>
							<ClayForm.FeedbackIndicator symbol="exclamation-full" />
							{Liferay.Language.get('this-is-an-invalid-tag')}
						</ClayForm.FeedbackItem>
					)}
				</ClayForm.FeedbackGroup>
			</ClayForm.Group>
		</>
	);
};
