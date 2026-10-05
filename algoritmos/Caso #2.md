# Case #2 - 35%

## Problem Description

Costa Rica has some of the most severe vehicle traffic problems in all of Latin America. Although substantial road expansions have been completed, those improvements follow designs made back in the 1980s. That, combined with a growing vehicle fleet and changes in mobility such as remote work, airports, and more prosperous cities, makes it particularly hard to predict where citizens are going to travel, where the biggest traffic bottlenecks are going to appear, and even more so what capacity the routes should have.

For that reason, you have been given the mission of building a platform that can analyze the current situation and predict the behavior of the national vehicle fleet 1, 3, 7, and up to K years into the future (n years ahead).

The platform must have information and strategies that cover topics such as:

- Size of the vehicle fleet at the national, provincial, and cantonal levels, and by strategic zones such as the GAM (Greater Metropolitan Area), Zona Norte, Pacífico Central, Pacífico Norte, Caribe Sur, etc.

- Cantonal, provincial, and national streets and routes.

- Traffic loads on streets and routes.

- Important landmarks such as companies, malls, workplaces, entertainment areas, shopping centers, tourist spots, government institutions, schools, high schools, and public and private universities, etc., where people usually travel to. Their location and access routes must be properly identified.

- Usual routes between landmarks, cantons, cities, and any other relevant points.

- Mobility behavior of people going to work, appointments, errands, and shopping, taking into account days of the week, days of the month, schedules, and durations.

- Behavior during holidays, special dates, events, concerts, games, and other particular occasions that can substantially increase or decrease the vehicle flow at a given point.

- Growth rates over time for all of the metrics above.

- Zones, areas, or infrastructure that are growing and could increase or decrease vehicle traffic.

All of this information does not have to exist exhaustively (100%). Instead, there must be a model that can deduce and generate whatever information is needed for the time span of interest. This way, the current and future state (in years) of the infrastructure and the vehicle flow can be simulated statistically and probabilistically to produce forecasts of those capacities. It works like a simulation, but a calculated one, so that it can even produce estimates for data gaps that do not exist in the sources.

Finally, the user will be able to query the system through an intelligent chat, asking questions such as:

1. Will the Hispanidad roundabout allow access to Mall San Pedro in December 2030?

2. How many vehicles per day will be entering La Sabana in 2027?

3. How many cars travel from Cartago to San José in the morning?

4. Which malls will have the biggest impact on traffic jams by the end of 2028?

And similar questions.

## What the student must do

1. Create a data source to feed the probabilistic algorithm.

2. Create a genetic algorithm that generates driver behavior: deciding where drivers will go, when they will go, whether they will crash and cause a traffic jam, whether they will go to a certain place, whether they will drive fast or slow (that is, their speed), who will or will not cause a jam, which routes they will use, which days they will take the car out, whether they will take a trip far from home, among other behavioral actions. This algorithm must be written in C++.

3. Create a probabilistic algorithm that uses the data source and the information generated in real time by the GA to run a probabilistic, sampling-based simulation that extracts and estimates the data needed to answer the user's questions. This algorithm must be written in C++. It must have an objective function based on validation data points that measures how correct the answer is and how close it is to the right answer over time. For this reason, the calculation process (random numbers and sampling) must keep iterating until the objective validation function is met.

4. Create an MCP Server with the tools needed to break down the user's questions and extract the parameters required to query the probabilistic algorithm. The LLM then uses the information returned to write the final answer for the user. This must be done in Python, and the chat or command-line interaction must also be in Python.

---

## Desirable Programming Details

This section explains what is expected from each component in more depth. Items marked **(required)** come directly from the requirements above. The rest are **desirable** practices that make the solution stronger, easier to defend during the review, and closer to what the professor will look for.


The four components form a pipeline that runs **every time the user asks a question**:

```
User (Python chat)
   │  natural-language question
   ▼
LLM  ──calls tool──►  MCP Server (Python)
                         │  structured parameters (JSON)
                         ▼
                 C++ engine (one executable or library)
                   ├── loads data source (CSV / JSON / YAML)
                   ├── GA: evolves a population of driver behaviors
                   └── Probabilistic simulator: samples trips, accumulates
                       loads, iterates until the objective function is met
                         │  estimate + confidence + metrics (JSON)
                         ▼
                 MCP Server returns the result to the LLM
                         ▼
               LLM writes the final answer to the user
```

- **Clear contract between Python and C++.** Define a JSON request/response format (for example, the MCP server calls the C++ executable via `subprocess` and passes JSON through stdin/stdout, or uses `pybind11` to expose C++ functions). Document the contract in the source code or readme. 

- **No precomputed results (required).** The GA and the probabilistic algorithm must generate the simulated information *at query time*. They must not write computed data to disk to be looked up later. Loading the base data source into memory at startup is fine.

- **Reproducibility.** Every run should accept an optional `seed`. With the same seed and the same parameters, the result must be identical. This is essential for debugging and for showing results to the professor (see *Reproducible Randomness*, Week #10).

- **Execution metrics.** Each response should include: GA generations run, final best fitness, number of samples drawn, number of iterations of the probabilistic loop, final error against the validation points, confidence interval, and elapsed time. These metrics help defend the design during the review.

- **Separation of concerns.** Keep separate modules (classes/files) for: data loading, road graph, GA, simulator, objective function, and the JSON interface. 

- Use public sources where possible (for example INEC, MOPT/CONAVI traffic counts, COSEVI, OpenStreetMap for the road graph and landmarks). Where there is no data, probabilistic estimations are perform.

- Keep the graph a manageable size: model the main national/provincial routes and the cantonal streets around the landmarks you care about, not every street in the country, the rest must be deduced or generated by the algorithm. 

- Be aware of **units** (vehicles/hour, km, km/h) in column names or a data dictionary.

- Generate a population of driver behaviors that, when aggregated, is consistent with the known data, and that can be projected into the future. A recommended way of thinking about it: each **individual** in the population is a **behavior profile** for a group of drivers (an "agent" that represents W real vehicles). The GA evolves the population so that, when simulated, its aggregate behavior matches the observed data (fleet sizes, traffic counts, trip patterns). This is a calibration problem that a GA fits well, because the search space of possible behaviors is huge and has no analytical solution.

- **Initial population.** Do not use a uniform random population. Seed it from the data.

- **Fitness function.** It must measure how well the population reproduces reality. For example:
  `fitness = 1 / (1 + Σ_i w_i · |simulated_i − observed_i| / observed_i)`
  where `i` iterates over calibration data points (counts on edges, fleet per zone, share of trips per hour). 

- **Projection into the future.** Describe how the population changes for a target year: for example, scale the represented vehicles with the fleet growth rate, change destination weights with landmark growth and new infrastructure, adjust remote-work days, and then run a few generations to re-calibrate.

- **Probabilistic Goal:** answer a specific question (a place, a time window, a target year) by simulating many random scenarios built from the data and the GA population, and estimating the requested quantity with a known level of confidence.

- **Classify the algorithm using course concepts.** Explain whether it behaves as a Monte Carlo algorithm (bounded time, possibly inaccurate answer) or as Las Vegas (repeat until the validation criterion is met). 

- Turn a natural-language question into a call to the C++ engine and return structured data that the LLM can explain.

- Use the official Python MCP SDK (`mcp`, for example `FastMCP`) and give every tool a clear description and typed parameters. The LLM selects the tool based on those descriptions.

- **Validate and normalize parameters** before calling C++: relative dates ("this morning", "end of 2028") must become explicit dates/hours; unknown places must return a helpful error, not a crash.

- **Return structured JSON** (estimate, interval, units, assumptions used, convergence metrics), not ready-made prose. The LLM is responsible for writing the answer.

- Instruct the LLM (system prompt) to always mention the uncertainty and the assumptions, and **never invent numbers** that the tool did not return.

- The chat can be a simple Python CLI that acts as the MCP client: it reads the user's question, sends it to the LLM along with the tools, executes the tool calls through the MCP server, and prints the final answer.

## Other Aspects

- Use free or very low-cost models or LLMs.
- The program runs on the local computer.
- The design of the GA and the probabilistic algorithm must be analyzed in depth together with the professor.
- You may design the solution using several GAs and several probabilistic algorithms; there is no restriction.
- The work can be done individually or in pairs.
- It is not necessary to create a database, although it is optional. The information can be CSV, YAML, or JSON as well.
- The probabilistic algorithms and GAs do not write new calculated data to be consulted later. Instead, they generate the simulated information at the moment of the user's query.
- The probabilistic algorithms and GAs must follow the structure seen in class.
- The project must be on GitHub with a proper `README.md`, which must include an explanation of the algorithmic techniques used by the student, with links to the key files, and a guide on how to run the solution.
- Last commit: Saturday, October 24.
- Review with the professor by prior appointment.
