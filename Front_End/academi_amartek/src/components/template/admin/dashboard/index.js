import Header from "../header";
import Sidebar from "../sidebar";

function Dashboard() {
	return (
		<div>
			<Header />
			<div style={{ display: "flex" }}>
				<Sidebar />
				<div
					style={{
						margin: "20px 30px 0 0",
						backgroundColor: "white",
						boxShadow: "0px 2px 25px rgba(157, 157, 157, 0.3)",
						height: "100%",
						width: "100%",
						padding: "10px",
					}}
				>
					<p>test from dashboard</p>
					<p>
						Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis maxime illum ex
						quas voluptates nisi odio quia neque aperiam dolore?
					</p>
				</div>
			</div>
		</div>
	);
}

export default Dashboard;
