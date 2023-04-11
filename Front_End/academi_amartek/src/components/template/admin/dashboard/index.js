import Header from "../header";
import Sidebar from "../sidebar";

function Dashboard() {
	return (
		<div>
			<Header />
			<div style={{ display: "flex" }}>
				<Sidebar />
				test
			</div>
		</div>
	);
}

export default Dashboard;
