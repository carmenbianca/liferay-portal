/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import ClayTabs from '@clayui/tabs';
import React, {useState} from 'react';

const Arrow = ({direction, handleClick}) => (
	<div className={`pull-${direction}`}>
		<ClayButton
			borderless
			className="icon-arrow"
			displayType="secondary"
			onClick={handleClick}
			size="lg"
		>
			<ClayIcon symbol={`angle-${direction}`} />
		</ClayButton>
	</div>
);

const InfoPanel = ({metadata}) => {
	const [activeTabKeyValue, setActiveTabKeyValue] = useState(0);

	const imageData = JSON.parse(metadata);

	const itemsHeader = imageData.groups.map((group, index) => {
		return (
			<ClayTabs.Item
				active={activeTabKeyValue == index}
				key={group.title}
				onClick={() => setActiveTabKeyValue(index)}
			>
				{group.title}
			</ClayTabs.Item>
		);
	});

	const itemsContent = imageData.groups.map((group, index) => {
		const itemContentTab = group.data.map(item => {
			return (
				<React.Fragment key={item.key}>
					<dt className="sidebar-dt">{item.key}</dt>
					<dd className="sidebar-dd">{item.value}</dd>
				</React.Fragment>
			);
		});

		return (
			<ClayTabs.TabPane
				aria-labelledby={`tab-${index}`}
				key={`tabPane-${index}`}
			>
				<dl className="sidebar-dl sidebar-section">{itemContentTab}</dl>
			</ClayTabs.TabPane>
		);
	});

	return (
		<div className="info-panel sidenav-menu-slider">
			<div className="sidebar-header">
				<ClayTabs modern>{itemsHeader}</ClayTabs>
			</div>
			<div className="sidebar-body">
				<ClayTabs.Content activeIndex={activeTabKeyValue} fade>
					{itemsContent}
				</ClayTabs.Content>
			</div>
		</div>
	);
};

const Carousel = ({
	currentItem,
	handleClickNext,
	handleClickPrevious,
	showArrows = true,
}) => (
	<div className="carousel closed sidenav-container">
		<InfoPanel metadata={currentItem.metadata} />

		<div className="sidenav-content">
			{showArrows && (
				<Arrow direction="left" handleClick={handleClickPrevious} />
			)}

			<img
				alt={currentItem.title}
				src={currentItem.url || currentItem.base64}
			/>

			{showArrows && (
				<Arrow direction="right" handleClick={handleClickNext} />
			)}
		</div>
	</div>
);

export default Carousel;
