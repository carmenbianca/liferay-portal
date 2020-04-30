/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import React, {useState} from 'react';

import SearchInput from '../search-input/SearchInput.es';

const Sidebar = React.forwardRef(({children, className}, ref) => {
	return (
		<div
			className={classNames(className, 'data-layout-builder-sidebar')}
			ref={ref}
		>
			<div className="sidebar sidebar-light">{children}</div>
		</div>
	);
});

const SidebarBody = ({children, className}) => {
	return (
		<div className={classNames(className, 'sidebar-body')}>{children}</div>
	);
};

const SidebarFooter = ({children}) => {
	return <div className="sidebar-footer">{children}</div>;
};

const SidebarHeader = ({children, className}) => {
	return (
		<div className={classNames(className, 'sidebar-header')}>
			{children}
		</div>
	);
};

const SidebarSearchInput = ({onSearch}) => (
	<div className="autofit-row sidebar-section">
		<div className="autofit-col autofit-col-expand">
			{onSearch && (
				<SearchInput onChange={searchText => onSearch(searchText)} />
			)}
		</div>
	</div>
);

const SidebarTabs = ({initialSelectedTab = 0, tabs}) => {
	const [selectedTab, setSelectedTab] = useState(initialSelectedTab);

	return (
		<>
			<SidebarTab
				onTabClick={setSelectedTab}
				selectedTab={selectedTab}
				tabs={tabs}
			/>

			<SidebarTabContent>{tabs[selectedTab].render()}</SidebarTabContent>
		</>
	);
};

const SidebarTab = ({onTabClick, selectedTab, tabs}) => {
	return (
		<nav className="component-tbar tbar">
			<div className="container-fluid">
				<ul className="nav nav-underline" role="tablist">
					{tabs.map(({label}, index) => (
						<li className="nav-item" key={index}>
							<button
								className={classNames(
									'btn btn-unstyled nav-link',
									{
										active: selectedTab === index,
									}
								)}
								data-senna-off
								onClick={event => {
									event.preventDefault();
									onTabClick(index);
								}}
								role="tab"
							>
								{label}
							</button>
						</li>
					))}
				</ul>
			</div>
		</nav>
	);
};

const SidebarTabContent = ({children}) => {
	return (
		<div className="tab-content">
			<div className="active fade mt-3 show tab-pane" role="tabpanel">
				{children}
			</div>
		</div>
	);
};

const SidebarTitle = ({title}) => (
	<div className="autofit-row mb-3 sidebar-section">
		<div className="autofit-col autofit-col-expand">
			<div className="component-title">
				<span className="text-truncate-inline">{title}</span>
			</div>
		</div>
	</div>
);

Sidebar.Body = SidebarBody;
Sidebar.Footer = SidebarFooter;
Sidebar.Header = SidebarHeader;
Sidebar.SearchInput = SidebarSearchInput;
Sidebar.Tab = SidebarTab;
Sidebar.Tabs = SidebarTabs;
Sidebar.TabContent = SidebarTabContent;
Sidebar.Title = SidebarTitle;

export {
	SidebarBody,
	SidebarFooter,
	SidebarHeader,
	SidebarSearchInput,
	SidebarTab,
	SidebarTabs,
	SidebarTabContent,
};

export default Sidebar;
