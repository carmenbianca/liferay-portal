/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayDropDown from '@clayui/drop-down';
import ClayIcon from '@clayui/icon';
import ClayLabel from '@clayui/label';
import PropTypes from 'prop-types';
import React, {useCallback, useState} from 'react';

function ChangeDefaultLanguage(props) {
	const [active, setActive] = useState(false);

	const [selectedDefaultLanguage, setSelectedDefaultLanguage] = useState(
		props.defaultLanguage
	);

	const onItemClick = useCallback((event, language) => {
		setSelectedDefaultLanguage(language);
		setActive(false);

		Liferay.fire('inputLocalized:defaultLocaleChanged', {
			item: event.currentTarget,
		});
	}, []);

	return (
		<div className="article-default-language">
			<p className="mb-0">
				<b>{`${Liferay.Language.get(
					'web-content-default-language'
				)}: `}</b>
				{props.strings[selectedDefaultLanguage]}
			</p>

			<ClayDropDown
				active={active}
				className="mt-2"
				onActiveChange={setActive}
				trigger={
					<ClayButton
						aria-expanded={active}
						aria-haspopup="true"
						className="dropdown-toggle"
						displayType="secondary"
					>
						<strong>{Liferay.Language.get('change')}</strong>
						<ClayIcon
							className="inline-item inline-item-after"
							symbol="caret-bottom"
						/>
					</ClayButton>
				}
			>
				<ClayDropDown.ItemList>
					{props.languages.map(item => (
						<ClayDropDown.Item
							className="autofit-row"
							data-value={item.label}
							key={item.label}
							onClick={event => onItemClick(event, item.label)}
							title={item.label}
						>
							<span className="autofit-col autofit-col-expand">
								<span className="autofit-section">
									<span className="inline-item inline-item-before">
										<ClayIcon symbol={item.icon}></ClayIcon>
									</span>
									{item.label}
								</span>
							</span>

							{item.label === selectedDefaultLanguage && (
								<span className="autofit-col">
									<ClayLabel displayType="info">
										{Liferay.Language.get('default')}
									</ClayLabel>
								</span>
							)}
						</ClayDropDown.Item>
					))}
				</ClayDropDown.ItemList>
			</ClayDropDown>
		</div>
	);
}

ChangeDefaultLanguage.propTypes = {
	languages: PropTypes.arrayOf(
		PropTypes.shape({
			icon: PropTypes.string,
			label: PropTypes.string,
		})
	).isRequired,
	strings: PropTypes.object.isRequired,
};

export default ChangeDefaultLanguage;
