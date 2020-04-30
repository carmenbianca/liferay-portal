/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';
import React, {useState} from 'react';

import AssetCategoriesSelector from './AssetCategoriesSelector.es';

function AssetCategoriesSelectorTag({
	eventName,
	groupIds = [],
	id,
	initialVocabularies = [],
	inputName,
	portletURL,
}) {
	const [vocabularies, setVocabularies] = useState(initialVocabularies);

	return (
		<AssetCategoriesSelector
			eventName={eventName}
			groupIds={groupIds}
			id={id}
			inputName={inputName}
			onVocabulariesChange={setVocabularies}
			portletURL={portletURL}
			vocabularies={vocabularies}
		/>
	);
}

AssetCategoriesSelectorTag.propTypes = {
	eventName: PropTypes.string,
	groupIds: PropTypes.array,
	id: PropTypes.string,
	initialVocabularies: PropTypes.array,
	inputName: PropTypes.string,
	portletURL: PropTypes.string,
};

export default function(props) {
	return (
		<AssetCategoriesSelectorTag
			{...props}
			initialVocabularies={props.vocabularies}
		/>
	);
}
