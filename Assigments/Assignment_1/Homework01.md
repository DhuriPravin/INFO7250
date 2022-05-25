# Homework 01

## PART 1 - Reading Assignment

## PART 2 - [Reading Assignment](https://github.com/DhuriPravin/INFO7250/blob/main/Assigments/Assignment_1/Assignment%201.docx)

## PART 3 - Programming Assignment

```javascript
MongoDB shell version v4.4.13
connecting to: mongodb://127.0.0.1:27017/?compressors=disabled&gssapiServiceName=mongodb
Implicit session: session { "id" : UUID("9c46c7a9-0dc8-44ba-81d8-df01529213a5") }
MongoDB server version: 4.4.13
---
The server generated these startup warnings when booting: 
        2022-05-22T18:45:53.563-04:00: Access control is not enabled for the database. Read and write access to data and configuration is unrestricted
---
---
        Enable MongoDB's free cloud-based monitoring service, which will then receive and display
        metrics about your deployment (disk utilization, CPU, operation statistics, etc).

        The monitoring data will be available on a MongoDB website with a unique URL accessible to you
        and anyone you share the URL with. MongoDB may use this information to make product
        improvements and to suggest MongoDB products and deployment options to you.

        To enable free monitoring, run the following command: db.enableFreeMonitoring()
        To permanently disable this reminder, run the following command: db.disableFreeMonitoring()
---

> show dbs
admin   0.000GB
cms     0.000GB
config  0.000GB
local   0.000GB
nysedb  0.044GB

> use cms
switched to db cms

> show collections
contact

> db.contact.findOne()
{
	"_id" : ObjectId("628ac47ffe655f5bb80f09ba"),
	"first_name" : "Gerrard",
	"last_name" : "Tallowin",
	"address" : "01 Buena Vista Alley",
	"city" : "San Francisco",
	"country" : "United States",
	"state" : "CA",
	"zip_code" : "94142",
	"phone" : "415-369-7442",
	"email" : "gtallowin0@java.com"
}

> db.contact.count()
10

> db.contact.remove({first_name: "Gerrard"})
WriteResult({ "nRemoved" : 1 })

> db.contact.count()
9

> db.contact.find({first_name: "Gerrard"})
>

> db.contact.find({first_name: "Umberto"}).pretty()

{
	"_id" : ObjectId("628ac581fe655f5bb80f09c2"),
	"first_name" : "Umberto",
	"last_name" : "Dunderdale",
	"address" : "1351 Clemons Hill",
	"city" : "Lawrenceville",
	"country" : "United States",
	"state" : "GA",
	"zip_code" : "30245",
	"phone" : "404-989-9633",
	"email" : "udunderdale8@cnn.com"
}

> db.contact.update({last_name: "Dunderdale"}, {$set: {last_name: "Dudley"}})
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })

> db.contact.find({first_name: "Umberto"}).pretty()
{
	"_id" : ObjectId("628ac581fe655f5bb80f09c2"),
	"first_name" : "Umberto",
	"last_name" : "Dudley",
	"address" : "1351 Clemons Hill",
	"city" : "Lawrenceville",
	"country" : "United States",
	"state" : "GA",
	"zip_code" : "30245",
	"phone" : "404-989-9633",
	"email" : "udunderdale8@cnn.com"
}
>

> show dbs
admin   0.000GB
cms     0.000GB
config  0.000GB
local   0.000GB
nysedb  0.044GB

> use cms
switched to db cms

> show collections
contact
```

## PART 4 - Programming Assignment

```javascript
> use games
switched to db games

> db.games.insert({name: "Mortal Kombat", genre: "Fighting", rating: 90})
WriteResult({ "nInserted" : 1 })
> db.games.insert({name: "PubG", genre: "Battle Royale", rating: 95})
WriteResult({ "nInserted" : 1 })
> db.games.insert({name: "The Legend of Zelda", genre: "Adventure", rating: 80})
WriteResult({ "nInserted" : 1 })
> db.games.insert({name: "FIFA", genre: "Sports", rating: 75})
WriteResult({ "nInserted" : 1 })
> db.games.insert({name: "Super Mario", genre: "Action", rating: 70})
WriteResult({ "nInserted" : 1 })

> db.games.count()
5

> show collections
games

> db.games.find().pretty()
{
	"_id" : ObjectId("628e2000b97bc284f55c909a"),
	"name" : "Mortal Kombat",
	"genre" : "Fighting",
	"rating" : 90
}
{
	"_id" : ObjectId("628e2055b97bc284f55c909b"),
	"name" : "PubG",
	"genre" : "Battle Royale",
	"rating" : 95
}
{
	"_id" : ObjectId("628e2077b97bc284f55c909c"),
	"name" : "The Legend of Zelda",
	"genre" : "Adventure",
	"rating" : 80
}
{
	"_id" : ObjectId("628e20b7b97bc284f55c909d"),
	"name" : "FIFA",
	"genre" : "Sports",
	"rating" : 75
}
{
	"_id" : ObjectId("628e210db97bc284f55c909e"),
	"name" : "Super Mario",
	"genre" : "Action",
	"rating" : 70
}

> db.games.find({genre: "Action"})
{ "_id" : ObjectId("628e210db97bc284f55c909e"), "name" : "Super Mario", "genre" : "Action", "rating" : 70 }

> db.games.findOne()
{
	"_id" : ObjectId("628e2000b97bc284f55c909a"),
	"name" : "Mortal Kombat",
	"genre" : "Fighting",
	"rating" : 90
}

> db.games.find({}).sort({rating:-1}).limit(3).pretty()
{
	"_id" : ObjectId("628e2055b97bc284f55c909b"),
	"name" : "PubG",
	"genre" : "Battle Royale",
	"rating" : 95
}
{
	"_id" : ObjectId("628e2000b97bc284f55c909a"),
	"name" : "Mortal Kombat",
	"genre" : "Fighting",
	"rating" : 90
}
{
	"_id" : ObjectId("628e2077b97bc284f55c909c"),
	"name" : "The Legend of Zelda",
	"genre" : "Adventure",
	"rating" : 80
}

> db.games.update({name:"PubG"}, {$set: {"Game Master": 1, "Speed Demon": 1}})
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })

> db.games.save({"_id" : ObjectId("628e2000b97bc284f55c909a"), 
"name" : "Mortal Kombat", 
"genre" : "Fighting", 
"rating" : 90,
"Game Master" : 1, "Speed Demon" : 1 })
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })

> db.games.find ( {"Game Master": 1, "Speed Demon": 1} )
{ "_id" : ObjectId("628e2000b97bc284f55c909a"), "name" : "Mortal Kombat", "genre" : "Fighting", "rating" : 90, "Game Master" : 1, "Speed Demon" : 1 }
{ "_id" : ObjectId("628e2055b97bc284f55c909b"), "name" : "PubG", "genre" : "Battle Royale", "rating" : 95, "Game Master" : 1, "Speed Demon" : 1 }

> db.games.update({name: "FIFA"}, { $set: {"Game Master": 1}})
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })

> db.games.update({name: "The Legend of Zelda"}, { $set: {"Speed Demon": 1}})
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })
```

## PART 5 - Programming Assignment

```javascript
> help
	db.help()                    help on db methods
	db.mycoll.help()             help on collection methods
	sh.help()                    sharding helpers
	rs.help()                    replica set helpers
	help admin                   administrative help
	help connect                 connecting to a db help
	help keys                    key shortcuts
	help misc                    misc things to know
	help mr                      mapreduce

	show dbs                     show database names
	show collections             show collections in current database
	show users                   show users in current database
	show profile                 show most recent system.profile entries with time >= 1ms
	show logs                    show the accessible logger names
	show log [name]              prints out the last segment of log in memory, 'global' is default
	use <db_name>                set current database
	db.mycoll.find()             list objects in collection mycoll
	db.mycoll.find( { a : 1 } )  list objects in mycoll where a == 1
	it                           result of the last line evaluated; use to further iterate
	DBQuery.shellBatchSize = x   set default number of items to display on shell
	exit                         quit the mongo shell
> show dbs
admin   0.000GB
cms     0.000GB
config  0.000GB
games   0.000GB
local   0.000GB
nysedb  0.044GB

> use cms
switched to db cms

> show collections
contact

> db.contact.find()
{ "_id" : ObjectId("628ac49afe655f5bb80f09bb"), "first_name" : "Tammie", "last_name" : "Steele", "address" : "619 Continental Way", "city" : "Hicksville", "country" : "United States", "state" : "NY", "zip_code" : "11854", "phone" : "516-431-7629", "email" : "tsteele1@wsj.com" }
{ "_id" : ObjectId("628ac4a3fe655f5bb80f09bc"), "first_name" : "Matilda", "last_name" : "Gary", "address" : "050 Fair Oaks Way", "city" : "Anaheim", "country" : "United States", "state" : "CA", "zip_code" : "92825", "phone" : "714-842-7084", "email" : "mgary2@cafepress.com" }
{ "_id" : ObjectId("628ac521fe655f5bb80f09bd"), "first_name" : "Ambrosio", "last_name" : "Siverns", "address" : "65 Thackeray Street", "city" : "Winston Salem", "country" : "United States", "state" : "NC", "zip_code" : "27157", "phone" : "336-540-9123", "email" : "asiverns3@bing.com" }
{ "_id" : ObjectId("628ac55cfe655f5bb80f09be"), "first_name" : "Nata", "last_name" : "Arendsen", "address" : "69963 Waubesa Way", "city" : "San Antonio", "country" : "United States", "state" : "TX", "zip_code" : "78225", "phone" : "210-797-9926", "email" : "narendsen4@nature.com" }
{ "_id" : ObjectId("628ac564fe655f5bb80f09bf"), "first_name" : "Jordana", "last_name" : "Tisun", "address" : "460 Fisk Junction", "city" : "Honolulu", "country" : "United States", "state" : "HI", "zip_code" : "96835", "phone" : "808-275-1683", "email" : "jtisun5@miibeian.gov.cn" }
{ "_id" : ObjectId("628ac56cfe655f5bb80f09c0"), "first_name" : "Jordanna", "last_name" : "Spiby", "address" : "5743 Green Ridge Alley", "city" : "Pasadena", "country" : "United States", "state" : "CA", "zip_code" : "91117", "phone" : "626-987-0054", "email" : "jspiby6@businessinsider.com" }
{ "_id" : ObjectId("628ac57afe655f5bb80f09c1"), "first_name" : "Eadith", "last_name" : "Hynam", "address" : "552 Judy Lane", "city" : "Redwood City", "country" : "United States", "state" : "CA", "zip_code" : "94064", "phone" : "650-428-4129", "email" : "ehynam7@ocn.ne.jp" }
{ "_id" : ObjectId("628ac581fe655f5bb80f09c2"), "first_name" : "Umberto", "last_name" : "Dudley", "address" : "1351 Clemons Hill", "city" : "Lawrenceville", "country" : "United States", "state" : "GA", "zip_code" : "30245", "phone" : "404-989-9633", "email" : "udunderdale8@cnn.com" }
{ "_id" : ObjectId("628ac589fe655f5bb80f09c3"), "first_name" : "Cathyleen", "last_name" : "McFade", "address" : "5485 Autumn Leaf Trail", "city" : "Orlando", "country" : "United States", "state" : "FL", "zip_code" : "32854", "phone" : "407-608-0122", "email" : "cmcfade9@nyu.edu" }

> db.contact.find({"first_name": "Nata"})
{ "_id" : ObjectId("628ac55cfe655f5bb80f09be"), "first_name" : "Nata", "last_name" : "Arendsen", "address" : "69963 Waubesa Way", "city" : "San Antonio", "country" : "United States", "state" : "TX", "zip_code" : "78225", "phone" : "210-797-9926", "email" : "narendsen4@nature.com" }


> db.help()
DB methods:
	db.adminCommand(nameOrDocument) - switches to 'admin' db, and runs command [just calls db.runCommand(...)]
	db.aggregate([pipeline], {options}) - performs a collectionless aggregation on this database; returns a cursor
	db.auth(username, password)
	db.cloneDatabase(fromhost) - will only function with MongoDB 4.0 and below
	db.commandHelp(name) returns the help for the command
	db.copyDatabase(fromdb, todb, fromhost) - will only function with MongoDB 4.0 and below
	db.createCollection(name, {size: ..., capped: ..., max: ...})
	db.createUser(userDocument)
	db.createView(name, viewOn, [{$operator: {...}}, ...], {viewOptions})
	db.currentOp() displays currently executing operations in the db
	db.dropDatabase(writeConcern)
	db.dropUser(username)
	db.eval() - deprecated
	db.fsyncLock() flush data to disk and lock server for backups
	db.fsyncUnlock() unlocks server following a db.fsyncLock()
	db.getCollection(cname) same as db['cname'] or db.cname
	db.getCollectionInfos([filter]) - returns a list that contains the names and options of the db's collections
	db.getCollectionNames()
	db.getLastError() - just returns the err msg string
	db.getLastErrorObj() - return full status object
	db.getLogComponents()
	db.getMongo() get the server connection object
	db.getMongo().setSecondaryOk() allow queries on a replication secondary server
	db.getName()
	db.getProfilingLevel() - deprecated
	db.getProfilingStatus() - returns if profiling is on and slow threshold
	db.getReplicationInfo()
	db.getSiblingDB(name) get the db at the same server as this one
	db.getWriteConcern() - returns the write concern used for any operations on this db, inherited from server object if set
	db.hostInfo() get details about the server's host
	db.isMaster() check replica primary status
	db.hello() check replica primary status
	db.killOp(opid) kills the current operation in the db
	db.listCommands() lists all the db commands
	db.loadServerScripts() loads all the scripts in db.system.js
	db.logout()
	db.printCollectionStats()
	db.printReplicationInfo()
	db.printShardingStatus()
	db.printSecondaryReplicationInfo()
	db.resetError()
	db.runCommand(cmdObj) run a database command.  if cmdObj is a string, turns it into {cmdObj: 1}
	db.serverStatus()
	db.setLogLevel(level,<component>)
	db.setProfilingLevel(level,slowms) 0=off 1=slow 2=all
	db.setVerboseShell(flag) display extra information in shell output
	db.setWriteConcern(<write concern doc>) - sets the write concern for writes to the db
	db.shutdownServer()
	db.stats()
	db.unsetWriteConcern(<write concern doc>) - unsets the write concern for writes to the db
	db.version() current version of the server
	db.watch() - opens a change stream cursor for a database to report on all  changes to its non-system collections.

> db.printCollectionStats()
contact
{
	"ns" : "cms.contact",
	"size" : 2137,
	"count" : 9,
	"avgObjSize" : 237,
	"storageSize" : 36864,
	"freeStorageSize" : 16384,
	"capped" : false,
	"wiredTiger" : {
		"metadata" : {
			"formatVersion" : 1
		},
		"creationString" : "access_pattern_hint=none,allocation_size=4KB,app_metadata=(formatVersion=1),assert=(commit_timestamp=none,durable_timestamp=none,read_timestamp=none,write_timestamp=off),block_allocation=best,block_compressor=snappy,cache_resident=false,checksum=on,colgroups=,collator=,columns=,dictionary=0,encryption=(keyid=,name=),exclusive=false,extractor=,format=btree,huffman_key=,huffman_value=,ignore_in_memory_cache_size=false,immutable=false,import=(enabled=false,file_metadata=,repair=false),internal_item_max=0,internal_key_max=0,internal_key_truncate=true,internal_page_max=4KB,key_format=q,key_gap=10,leaf_item_max=0,leaf_key_max=0,leaf_page_max=32KB,leaf_value_max=64MB,log=(enabled=true),lsm=(auto_throttle=true,bloom=true,bloom_bit_count=16,bloom_config=,bloom_hash_count=8,bloom_oldest=false,chunk_count_limit=0,chunk_max=5GB,chunk_size=10MB,merge_custom=(prefix=,start_generation=0,suffix=),merge_max=15,merge_min=0),memory_page_image_max=0,memory_page_max=10m,os_cache_dirty_max=0,os_cache_max=0,prefix_compression=false,prefix_compression_min=4,readonly=false,source=,split_deepen_min_child=0,split_deepen_per_child=0,split_pct=90,tiered_object=false,tiered_storage=(auth_token=,bucket=,bucket_prefix=,cache_directory=,local_retention=300,name=,object_target_size=10M),type=file,value_format=u,verbose=[],write_timestamp_usage=none",
		"type" : "file",
		"uri" : "statistics:table:collection-0--1653395909335473038",
		"LSM" : {
			"bloom filter false positives" : 0,
			"bloom filter hits" : 0,
			"bloom filter misses" : 0,
			"bloom filter pages evicted from cache" : 0,
			"bloom filter pages read into cache" : 0,
			"bloom filters in the LSM tree" : 0,
			"chunks in the LSM tree" : 0,
			"highest merge generation in the LSM tree" : 0,
			"queries that could have benefited from a Bloom filter that did not exist" : 0,
			"sleep for LSM checkpoint throttle" : 0,
			"sleep for LSM merge throttle" : 0,
			"total size of bloom filters" : 0
		},
		"block-manager" : {
			"allocations requiring file extension" : 0,
			"blocks allocated" : 0,
			"blocks freed" : 0,
			"checkpoint size" : 4096,
			"file allocation unit size" : 4096,
			"file bytes available for reuse" : 16384,
			"file magic number" : 120897,
			"file major version number" : 1,
			"file size in bytes" : 36864,
			"minor version number" : 0
		},
		"btree" : {
			"btree checkpoint generation" : 503,
			"btree clean tree checkpoint expiration time" : NumberLong("9223372036854775807"),
			"btree compact pages reviewed" : 0,
			"btree compact pages selected to be rewritten" : 0,
			"btree compact pages skipped" : 0,
			"btree skipped by compaction as process would not reduce size" : 0,
			"column-store fixed-size leaf pages" : 0,
			"column-store internal pages" : 0,
			"column-store variable-size RLE encoded values" : 0,
			"column-store variable-size deleted values" : 0,
			"column-store variable-size leaf pages" : 0,
			"fixed-record size" : 0,
			"maximum internal page key size" : 368,
			"maximum internal page size" : 4096,
			"maximum leaf page key size" : 2867,
			"maximum leaf page size" : 32768,
			"maximum leaf page value size" : 67108864,
			"maximum tree depth" : 0,
			"number of key/value pairs" : 0,
			"overflow pages" : 0,
			"pages rewritten by compaction" : 0,
			"row-store empty values" : 0,
			"row-store internal pages" : 0,
			"row-store leaf pages" : 0
		},
		"cache" : {
			"bytes currently in the cache" : 2801,
			"bytes dirty in the cache cumulative" : 0,
			"bytes read into cache" : 2274,
			"bytes written from cache" : 0,
			"checkpoint blocked page eviction" : 0,
			"checkpoint of history store file blocked non-history store page eviction" : 0,
			"data source pages selected for eviction unable to be evicted" : 0,
			"eviction gave up due to detecting an out of order on disk value behind the last update on the chain" : 0,
			"eviction gave up due to detecting an out of order tombstone ahead of the selected on disk update" : 0,
			"eviction gave up due to detecting an out of order tombstone ahead of the selected on disk update after validating the update chain" : 0,
			"eviction gave up due to detecting out of order timestamps on the update chain after the selected on disk update" : 0,
			"eviction walk passes of a file" : 0,
			"eviction walk target pages histogram - 0-9" : 0,
			"eviction walk target pages histogram - 10-31" : 0,
			"eviction walk target pages histogram - 128 and higher" : 0,
			"eviction walk target pages histogram - 32-63" : 0,
			"eviction walk target pages histogram - 64-128" : 0,
			"eviction walk target pages reduced due to history store cache pressure" : 0,
			"eviction walks abandoned" : 0,
			"eviction walks gave up because they restarted their walk twice" : 0,
			"eviction walks gave up because they saw too many pages and found no candidates" : 0,
			"eviction walks gave up because they saw too many pages and found too few candidates" : 0,
			"eviction walks reached end of tree" : 0,
			"eviction walks restarted" : 0,
			"eviction walks started from root of tree" : 0,
			"eviction walks started from saved location in tree" : 0,
			"hazard pointer blocked page eviction" : 0,
			"history store table insert calls" : 0,
			"history store table insert calls that returned restart" : 0,
			"history store table out-of-order resolved updates that lose their durable timestamp" : 0,
			"history store table out-of-order updates that were fixed up by reinserting with the fixed timestamp" : 0,
			"history store table reads" : 0,
			"history store table reads missed" : 0,
			"history store table reads requiring squashed modifies" : 0,
			"history store table truncation by rollback to stable to remove an unstable update" : 0,
			"history store table truncation by rollback to stable to remove an update" : 0,
			"history store table truncation to remove an update" : 0,
			"history store table truncation to remove range of updates due to key being removed from the data page during reconciliation" : 0,
			"history store table truncation to remove range of updates due to out-of-order timestamp update on data page" : 0,
			"history store table writes requiring squashed modifies" : 0,
			"in-memory page passed criteria to be split" : 0,
			"in-memory page splits" : 0,
			"internal pages evicted" : 0,
			"internal pages split during eviction" : 0,
			"leaf pages split during eviction" : 0,
			"modified pages evicted" : 0,
			"overflow pages read into cache" : 0,
			"page split during eviction deepened the tree" : 0,
			"page written requiring history store records" : 0,
			"pages read into cache" : 2,
			"pages read into cache after truncate" : 0,
			"pages read into cache after truncate in prepare state" : 0,
			"pages requested from the cache" : 2,
			"pages seen by eviction walk" : 0,
			"pages written from cache" : 0,
			"pages written requiring in-memory restoration" : 0,
			"the number of times full update inserted to history store" : 0,
			"the number of times reverse modify inserted to history store" : 0,
			"tracked dirty bytes in the cache" : 0,
			"unmodified pages evicted" : 0
		},
		"cache_walk" : {
			"Average difference between current eviction generation when the page was last considered" : 0,
			"Average on-disk page image size seen" : 0,
			"Average time in cache for pages that have been visited by the eviction server" : 0,
			"Average time in cache for pages that have not been visited by the eviction server" : 0,
			"Clean pages currently in cache" : 0,
			"Current eviction generation" : 0,
			"Dirty pages currently in cache" : 0,
			"Entries in the root page" : 0,
			"Internal pages currently in cache" : 0,
			"Leaf pages currently in cache" : 0,
			"Maximum difference between current eviction generation when the page was last considered" : 0,
			"Maximum page size seen" : 0,
			"Minimum on-disk page image size seen" : 0,
			"Number of pages never visited by eviction server" : 0,
			"On-disk page image sizes smaller than a single allocation unit" : 0,
			"Pages created in memory and never written" : 0,
			"Pages currently queued for eviction" : 0,
			"Pages that could not be queued for eviction" : 0,
			"Refs skipped during cache traversal" : 0,
			"Size of the root page" : 0,
			"Total number of pages currently in cache" : 0
		},
		"checkpoint-cleanup" : {
			"pages added for eviction" : 0,
			"pages removed" : 0,
			"pages skipped during tree walk" : 0,
			"pages visited" : 0
		},
		"compression" : {
			"compressed page maximum internal page size prior to compression" : 4096,
			"compressed page maximum leaf page size prior to compression " : 131072,
			"compressed pages read" : 0,
			"compressed pages written" : 0,
			"page written failed to compress" : 0,
			"page written was too small to compress" : 0
		},
		"cursor" : {
			"Total number of entries skipped by cursor next calls" : 0,
			"Total number of entries skipped by cursor prev calls" : 0,
			"Total number of entries skipped to position the history store cursor" : 0,
			"Total number of times a search near has exited due to prefix config" : 0,
			"bulk loaded cursor insert calls" : 0,
			"cache cursors reuse count" : 1,
			"close calls that result in cache" : 2,
			"create calls" : 1,
			"cursor next calls that skip due to a globally visible history store tombstone" : 0,
			"cursor next calls that skip greater than or equal to 100 entries" : 0,
			"cursor next calls that skip less than 100 entries" : 20,
			"cursor prev calls that skip due to a globally visible history store tombstone" : 0,
			"cursor prev calls that skip greater than or equal to 100 entries" : 0,
			"cursor prev calls that skip less than 100 entries" : 0,
			"insert calls" : 0,
			"insert key and value bytes" : 0,
			"modify" : 0,
			"modify key and value bytes affected" : 0,
			"modify value bytes modified" : 0,
			"next calls" : 20,
			"open cursor count" : 0,
			"operation restarted" : 0,
			"prev calls" : 0,
			"remove calls" : 0,
			"remove key bytes removed" : 0,
			"reserve calls" : 0,
			"reset calls" : 4,
			"search calls" : 0,
			"search history store calls" : 0,
			"search near calls" : 0,
			"truncate calls" : 0,
			"update calls" : 0,
			"update key and value bytes" : 0,
			"update value size change" : 0
		},
		"reconciliation" : {
			"approximate byte size of timestamps in pages written" : 0,
			"approximate byte size of transaction IDs in pages written" : 0,
			"dictionary matches" : 0,
			"fast-path pages deleted" : 0,
			"internal page key bytes discarded using suffix compression" : 0,
			"internal page multi-block writes" : 0,
			"internal-page overflow keys" : 0,
			"leaf page key bytes discarded using prefix compression" : 0,
			"leaf page multi-block writes" : 0,
			"leaf-page overflow keys" : 0,
			"maximum blocks required for a page" : 0,
			"overflow values written" : 0,
			"page checksum matches" : 0,
			"page reconciliation calls" : 0,
			"page reconciliation calls for eviction" : 0,
			"pages deleted" : 0,
			"pages written including an aggregated newest start durable timestamp " : 0,
			"pages written including an aggregated newest stop durable timestamp " : 0,
			"pages written including an aggregated newest stop timestamp " : 0,
			"pages written including an aggregated newest stop transaction ID" : 0,
			"pages written including an aggregated newest transaction ID " : 0,
			"pages written including an aggregated oldest start timestamp " : 0,
			"pages written including an aggregated prepare" : 0,
			"pages written including at least one prepare" : 0,
			"pages written including at least one start durable timestamp" : 0,
			"pages written including at least one start timestamp" : 0,
			"pages written including at least one start transaction ID" : 0,
			"pages written including at least one stop durable timestamp" : 0,
			"pages written including at least one stop timestamp" : 0,
			"pages written including at least one stop transaction ID" : 0,
			"records written including a prepare" : 0,
			"records written including a start durable timestamp" : 0,
			"records written including a start timestamp" : 0,
			"records written including a start transaction ID" : 0,
			"records written including a stop durable timestamp" : 0,
			"records written including a stop timestamp" : 0,
			"records written including a stop transaction ID" : 0
		},
		"session" : {
			"object compaction" : 0,
			"tiered operations dequeued and processed" : 0,
			"tiered operations scheduled" : 0,
			"tiered storage local retention time (secs)" : 0,
			"tiered storage object size" : 0
		},
		"transaction" : {
			"race to read prepared update retry" : 0,
			"rollback to stable history store records with stop timestamps older than newer records" : 0,
			"rollback to stable inconsistent checkpoint" : 0,
			"rollback to stable keys removed" : 0,
			"rollback to stable keys restored" : 0,
			"rollback to stable restored tombstones from history store" : 0,
			"rollback to stable restored updates from history store" : 0,
			"rollback to stable skipping delete rle" : 0,
			"rollback to stable skipping stable rle" : 0,
			"rollback to stable sweeping history store keys" : 0,
			"rollback to stable updates removed from history store" : 0,
			"transaction checkpoints due to obsolete pages" : 0,
			"update conflicts" : 0
		}
	},
	"nindexes" : 1,
	"indexBuilds" : [ ],
	"totalIndexSize" : 36864,
	"totalSize" : 73728,
	"indexSizes" : {
		"_id_" : 36864
	},
	"scaleFactor" : 1,
	"ok" : 1
}
---
> db.stats()
{
	"db" : "cms",
	"collections" : 1,
	"views" : 0,
	"objects" : 9,
	"avgObjSize" : 237.44444444444446,
	"dataSize" : 2137,
	"storageSize" : 36864,
	"indexes" : 1,
	"indexSize" : 36864,
	"totalSize" : 73728,
	"scaleFactor" : 1,
	"fsUsedSize" : 195251572736,
	"fsTotalSize" : 245107195904,
	"ok" : 1
}

> db.version()
4.4.13

> db.getCollectionNames()
[ "contact" ]

> db.getLastError()
null

> db.mycoll.help()
DBCollection help
	db.mycoll.find().help() - show DBCursor help
	db.mycoll.bulkWrite( operations, <optional params> ) - bulk execute write operations, optional parameters are: w, wtimeout, j
	db.mycoll.count( query = {}, <optional params> ) - count the number of documents that matches the query, optional parameters are: limit, skip, hint, maxTimeMS
	db.mycoll.countDocuments( query = {}, <optional params> ) - count the number of documents that matches the query, optional parameters are: limit, skip, hint, maxTimeMS
	db.mycoll.estimatedDocumentCount( <optional params> ) - estimate the document count using collection metadata, optional parameters are: maxTimeMS
	db.mycoll.convertToCapped(maxBytes) - calls {convertToCapped:'mycoll', size:maxBytes}} command
	db.mycoll.createIndex(keypattern[,options])
	db.mycoll.createIndexes([keypatterns], <options>)
	db.mycoll.dataSize()
	db.mycoll.deleteOne( filter, <optional params> ) - delete first matching document, optional parameters are: w, wtimeout, j
	db.mycoll.deleteMany( filter, <optional params> ) - delete all matching documents, optional parameters are: w, wtimeout, j
	db.mycoll.distinct( key, query, <optional params> ) - e.g. db.mycoll.distinct( 'x' ), optional parameters are: maxTimeMS
	db.mycoll.drop() drop the collection
	db.mycoll.dropIndex(index) - e.g. db.mycoll.dropIndex( "indexName" ) or db.mycoll.dropIndex( { "indexKey" : 1 } )
	db.mycoll.hideIndex(index) - e.g. db.mycoll.hideIndex( "indexName" ) or db.mycoll.hideIndex( { "indexKey" : 1 } )
	db.mycoll.unhideIndex(index) - e.g. db.mycoll.unhideIndex( "indexName" ) or db.mycoll.unhideIndex( { "indexKey" : 1 } )
	db.mycoll.dropIndexes()
	db.mycoll.ensureIndex(keypattern[,options]) - DEPRECATED, use createIndex() instead
	db.mycoll.explain().help() - show explain help
	db.mycoll.reIndex()
	db.mycoll.find([query],[fields]) - query is an optional query filter. fields is optional set of fields to return.
	                                              e.g. db.mycoll.find( {x:77} , {name:1, x:1} )
	db.mycoll.find(...).count()
	db.mycoll.find(...).limit(n)
	db.mycoll.find(...).skip(n)
	db.mycoll.find(...).sort(...)
	db.mycoll.findOne([query], [fields], [options], [readConcern])
	db.mycoll.findOneAndDelete( filter, <optional params> ) - delete first matching document, optional parameters are: projection, sort, maxTimeMS
	db.mycoll.findOneAndReplace( filter, replacement, <optional params> ) - replace first matching document, optional parameters are: projection, sort, maxTimeMS, upsert, returnNewDocument
	db.mycoll.findOneAndUpdate( filter, <update object or pipeline>, <optional params> ) - update first matching document, optional parameters are: projection, sort, maxTimeMS, upsert, returnNewDocument
	db.mycoll.getDB() get DB object associated with collection
	db.mycoll.getPlanCache() get query plan cache associated with collection
	db.mycoll.getIndexes()
	db.mycoll.insert(obj)
	db.mycoll.insertOne( obj, <optional params> ) - insert a document, optional parameters are: w, wtimeout, j
	db.mycoll.insertMany( [objects], <optional params> ) - insert multiple documents, optional parameters are: w, wtimeout, j
	db.mycoll.mapReduce( mapFunction , reduceFunction , <optional params> )
	db.mycoll.aggregate( [pipeline], <optional params> ) - performs an aggregation on a collection; returns a cursor
	db.mycoll.remove(query)
	db.mycoll.replaceOne( filter, replacement, <optional params> ) - replace the first matching document, optional parameters are: upsert, w, wtimeout, j
	db.mycoll.renameCollection( newName , <dropTarget> ) renames the collection.
	db.mycoll.runCommand( name , <options> ) runs a db command with the given name where the first param is the collection name
	db.mycoll.save(obj)
	db.mycoll.stats({scale: N, indexDetails: true/false, indexDetailsKey: <index key>, indexDetailsName: <index name>})
	db.mycoll.storageSize() - includes free space allocated to this collection
	db.mycoll.totalIndexSize() - size in bytes of all the indexes
	db.mycoll.totalSize() - storage allocated for all data and indexes
	db.mycoll.update( query, <update object or pipeline>[, upsert_bool, multi_bool] ) - instead of two flags, you can pass an object with fields: upsert, multi, hint
	db.mycoll.updateOne( filter, <update object or pipeline>, <optional params> ) - update the first matching document, optional parameters are: upsert, w, wtimeout, j, hint
	db.mycoll.updateMany( filter, <update object or pipeline>, <optional params> ) - update all matching documents, optional parameters are: upsert, w, wtimeout, j, hint
	db.mycoll.validate( <full> ) - SLOW
	db.mycoll.getShardVersion() - only for use with sharding
	db.mycoll.getShardDistribution() - prints statistics about data distribution in the cluster
	db.mycoll.getSplitKeysForChunks( <maxChunkSize> ) - calculates split points over all chunks and returns splitter function
	db.mycoll.getWriteConcern() - returns the write concern used for any operations on this collection, inherited from server/db if set
	db.mycoll.setWriteConcern( <write concern doc> ) - sets the write concern for writes to the collection
	db.mycoll.unsetWriteConcern( <write concern doc> ) - unsets the write concern for writes to the collection
	db.mycoll.latencyStats() - display operation latency histograms for this collection
> cls
> db.mycoll.help()
DBCollection help
	db.mycoll.find().help() - show DBCursor help
	db.mycoll.bulkWrite( operations, <optional params> ) - bulk execute write operations, optional parameters are: w, wtimeout, j
	db.mycoll.count( query = {}, <optional params> ) - count the number of documents that matches the query, optional parameters are: limit, skip, hint, maxTimeMS
	db.mycoll.countDocuments( query = {}, <optional params> ) - count the number of documents that matches the query, optional parameters are: limit, skip, hint, maxTimeMS
	db.mycoll.estimatedDocumentCount( <optional params> ) - estimate the document count using collection metadata, optional parameters are: maxTimeMS
	db.mycoll.convertToCapped(maxBytes) - calls {convertToCapped:'mycoll', size:maxBytes}} command
	db.mycoll.createIndex(keypattern[,options])
	db.mycoll.createIndexes([keypatterns], <options>)
	db.mycoll.dataSize()
	db.mycoll.deleteOne( filter, <optional params> ) - delete first matching document, optional parameters are: w, wtimeout, j
	db.mycoll.deleteMany( filter, <optional params> ) - delete all matching documents, optional parameters are: w, wtimeout, j
	db.mycoll.distinct( key, query, <optional params> ) - e.g. db.mycoll.distinct( 'x' ), optional parameters are: maxTimeMS
	db.mycoll.drop() drop the collection
	db.mycoll.dropIndex(index) - e.g. db.mycoll.dropIndex( "indexName" ) or db.mycoll.dropIndex( { "indexKey" : 1 } )
	db.mycoll.hideIndex(index) - e.g. db.mycoll.hideIndex( "indexName" ) or db.mycoll.hideIndex( { "indexKey" : 1 } )
	db.mycoll.unhideIndex(index) - e.g. db.mycoll.unhideIndex( "indexName" ) or db.mycoll.unhideIndex( { "indexKey" : 1 } )
	db.mycoll.dropIndexes()
	db.mycoll.ensureIndex(keypattern[,options]) - DEPRECATED, use createIndex() instead
	db.mycoll.explain().help() - show explain help
	db.mycoll.reIndex()
	db.mycoll.find([query],[fields]) - query is an optional query filter. fields is optional set of fields to return.
	                                              e.g. db.mycoll.find( {x:77} , {name:1, x:1} )
	db.mycoll.find(...).count()
	db.mycoll.find(...).limit(n)
	db.mycoll.find(...).skip(n)
	db.mycoll.find(...).sort(...)
	db.mycoll.findOne([query], [fields], [options], [readConcern])
	db.mycoll.findOneAndDelete( filter, <optional params> ) - delete first matching document, optional parameters are: projection, sort, maxTimeMS
	db.mycoll.findOneAndReplace( filter, replacement, <optional params> ) - replace first matching document, optional parameters are: projection, sort, maxTimeMS, upsert, returnNewDocument
	db.mycoll.findOneAndUpdate( filter, <update object or pipeline>, <optional params> ) - update first matching document, optional parameters are: projection, sort, maxTimeMS, upsert, returnNewDocument
	db.mycoll.getDB() get DB object associated with collection
	db.mycoll.getPlanCache() get query plan cache associated with collection
	db.mycoll.getIndexes()
	db.mycoll.insert(obj)
	db.mycoll.insertOne( obj, <optional params> ) - insert a document, optional parameters are: w, wtimeout, j
	db.mycoll.insertMany( [objects], <optional params> ) - insert multiple documents, optional parameters are: w, wtimeout, j
	db.mycoll.mapReduce( mapFunction , reduceFunction , <optional params> )
	db.mycoll.aggregate( [pipeline], <optional params> ) - performs an aggregation on a collection; returns a cursor
	db.mycoll.remove(query)
	db.mycoll.replaceOne( filter, replacement, <optional params> ) - replace the first matching document, optional parameters are: upsert, w, wtimeout, j
	db.mycoll.renameCollection( newName , <dropTarget> ) renames the collection.
	db.mycoll.runCommand( name , <options> ) runs a db command with the given name where the first param is the collection name
	db.mycoll.save(obj)
	db.mycoll.stats({scale: N, indexDetails: true/false, indexDetailsKey: <index key>, indexDetailsName: <index name>})
	db.mycoll.storageSize() - includes free space allocated to this collection
	db.mycoll.totalIndexSize() - size in bytes of all the indexes
	db.mycoll.totalSize() - storage allocated for all data and indexes
	db.mycoll.update( query, <update object or pipeline>[, upsert_bool, multi_bool] ) - instead of two flags, you can pass an object with fields: upsert, multi, hint
	db.mycoll.updateOne( filter, <update object or pipeline>, <optional params> ) - update the first matching document, optional parameters are: upsert, w, wtimeout, j, hint
	db.mycoll.updateMany( filter, <update object or pipeline>, <optional params> ) - update all matching documents, optional parameters are: upsert, w, wtimeout, j, hint
	db.mycoll.validate( <full> ) - SLOW
	db.mycoll.getShardVersion() - only for use with sharding
	db.mycoll.getShardDistribution() - prints statistics about data distribution in the cluster
	db.mycoll.getSplitKeysForChunks( <maxChunkSize> ) - calculates split points over all chunks and returns splitter function
	db.mycoll.getWriteConcern() - returns the write concern used for any operations on this collection, inherited from server/db if set
	db.mycoll.setWriteConcern( <write concern doc> ) - sets the write concern for writes to the collection
	db.mycoll.unsetWriteConcern( <write concern doc> ) - unsets the write concern for writes to the collection
	db.mycoll.latencyStats() - display operation latency histograms for this collection
> cls
> show dbs
admin   0.000GB
cms     0.000GB
config  0.000GB
games   0.000GB
local   0.000GB
nysedb  0.044GB
> use nysedb
switched to db nysedb
> show collections
sts
sts_avg
> db.mycoll.help()
DBCollection help
	db.mycoll.find().help() - show DBCursor help
	db.mycoll.bulkWrite( operations, <optional params> ) - bulk execute write operations, optional parameters are: w, wtimeout, j
	db.mycoll.count( query = {}, <optional params> ) - count the number of documents that matches the query, optional parameters are: limit, skip, hint, maxTimeMS
	db.mycoll.countDocuments( query = {}, <optional params> ) - count the number of documents that matches the query, optional parameters are: limit, skip, hint, maxTimeMS
	db.mycoll.estimatedDocumentCount( <optional params> ) - estimate the document count using collection metadata, optional parameters are: maxTimeMS
	db.mycoll.convertToCapped(maxBytes) - calls {convertToCapped:'mycoll', size:maxBytes}} command
	db.mycoll.createIndex(keypattern[,options])
	db.mycoll.createIndexes([keypatterns], <options>)
	db.mycoll.dataSize()
	db.mycoll.deleteOne( filter, <optional params> ) - delete first matching document, optional parameters are: w, wtimeout, j
	db.mycoll.deleteMany( filter, <optional params> ) - delete all matching documents, optional parameters are: w, wtimeout, j
	db.mycoll.distinct( key, query, <optional params> ) - e.g. db.mycoll.distinct( 'x' ), optional parameters are: maxTimeMS
	db.mycoll.drop() drop the collection
	db.mycoll.dropIndex(index) - e.g. db.mycoll.dropIndex( "indexName" ) or db.mycoll.dropIndex( { "indexKey" : 1 } )
	db.mycoll.hideIndex(index) - e.g. db.mycoll.hideIndex( "indexName" ) or db.mycoll.hideIndex( { "indexKey" : 1 } )
	db.mycoll.unhideIndex(index) - e.g. db.mycoll.unhideIndex( "indexName" ) or db.mycoll.unhideIndex( { "indexKey" : 1 } )
	db.mycoll.dropIndexes()
	db.mycoll.ensureIndex(keypattern[,options]) - DEPRECATED, use createIndex() instead
	db.mycoll.explain().help() - show explain help
	db.mycoll.reIndex()
	db.mycoll.find([query],[fields]) - query is an optional query filter. fields is optional set of fields to return.
	                                              e.g. db.mycoll.find( {x:77} , {name:1, x:1} )
	db.mycoll.find(...).count()
	db.mycoll.find(...).limit(n)
	db.mycoll.find(...).skip(n)
	db.mycoll.find(...).sort(...)
	db.mycoll.findOne([query], [fields], [options], [readConcern])
	db.mycoll.findOneAndDelete( filter, <optional params> ) - delete first matching document, optional parameters are: projection, sort, maxTimeMS
	db.mycoll.findOneAndReplace( filter, replacement, <optional params> ) - replace first matching document, optional parameters are: projection, sort, maxTimeMS, upsert, returnNewDocument
	db.mycoll.findOneAndUpdate( filter, <update object or pipeline>, <optional params> ) - update first matching document, optional parameters are: projection, sort, maxTimeMS, upsert, returnNewDocument
	db.mycoll.getDB() get DB object associated with collection
	db.mycoll.getPlanCache() get query plan cache associated with collection
	db.mycoll.getIndexes()
	db.mycoll.insert(obj)
	db.mycoll.insertOne( obj, <optional params> ) - insert a document, optional parameters are: w, wtimeout, j
	db.mycoll.insertMany( [objects], <optional params> ) - insert multiple documents, optional parameters are: w, wtimeout, j
	db.mycoll.mapReduce( mapFunction , reduceFunction , <optional params> )
	db.mycoll.aggregate( [pipeline], <optional params> ) - performs an aggregation on a collection; returns a cursor
	db.mycoll.remove(query)
	db.mycoll.replaceOne( filter, replacement, <optional params> ) - replace the first matching document, optional parameters are: upsert, w, wtimeout, j
	db.mycoll.renameCollection( newName , <dropTarget> ) renames the collection.
	db.mycoll.runCommand( name , <options> ) runs a db command with the given name where the first param is the collection name
	db.mycoll.save(obj)
	db.mycoll.stats({scale: N, indexDetails: true/false, indexDetailsKey: <index key>, indexDetailsName: <index name>})
	db.mycoll.storageSize() - includes free space allocated to this collection
	db.mycoll.totalIndexSize() - size in bytes of all the indexes
	db.mycoll.totalSize() - storage allocated for all data and indexes
	db.mycoll.update( query, <update object or pipeline>[, upsert_bool, multi_bool] ) - instead of two flags, you can pass an object with fields: upsert, multi, hint
	db.mycoll.updateOne( filter, <update object or pipeline>, <optional params> ) - update the first matching document, optional parameters are: upsert, w, wtimeout, j, hint
	db.mycoll.updateMany( filter, <update object or pipeline>, <optional params> ) - update all matching documents, optional parameters are: upsert, w, wtimeout, j, hint
	db.mycoll.validate( <full> ) - SLOW
	db.mycoll.getShardVersion() - only for use with sharding
	db.mycoll.getShardDistribution() - prints statistics about data distribution in the cluster
	db.mycoll.getSplitKeysForChunks( <maxChunkSize> ) - calculates split points over all chunks and returns splitter function
	db.mycoll.getWriteConcern() - returns the write concern used for any operations on this collection, inherited from server/db if set
	db.mycoll.setWriteConcern( <write concern doc> ) - sets the write concern for writes to the collection
	db.mycoll.unsetWriteConcern( <write concern doc> ) - unsets the write concern for writes to the collection
	db.mycoll.latencyStats() - display operation latency histograms for this collection

> db.sts.find().count()
735026

> db.sts.find().limit(5)
{ "_id" : ObjectId("62881dcbb09382e9bb51d5ea"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2010-02-04", "stock_price_open" : 4.55, "stock_price_high" : 4.69, "stock_price_low" : 4.39, "stock_price_close" : 4.42, "stock_volume" : 233800, "stock_price_adj_close" : 4.42 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d5eb"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2010-02-01", "stock_price_open" : 4.84, "stock_price_high" : 4.92, "stock_price_low" : 4.68, "stock_price_close" : 4.75, "stock_volume" : 194800, "stock_price_adj_close" : 4.75 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d5ec"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2010-01-29", "stock_price_open" : 4.97, "stock_price_high" : 5.05, "stock_price_low" : 4.76, "stock_price_close" : 4.83, "stock_volume" : 222900, "stock_price_adj_close" : 4.83 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d5ed"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2010-01-28", "stock_price_open" : 5.12, "stock_price_high" : 5.22, "stock_price_low" : 4.81, "stock_price_close" : 4.98, "stock_volume" : 283100, "stock_price_adj_close" : 4.98 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d5ee"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2010-01-27", "stock_price_open" : 4.82, "stock_price_high" : 5.16, "stock_price_low" : 4.79, "stock_price_close" : 5.09, "stock_volume" : 243500, "stock_price_adj_close" : 5.09 }

> db.sts.find().skip(20)
{ "_id" : ObjectId("62881dcbb09382e9bb51d5fe"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2010-01-22", "stock_price_open" : 5.52, "stock_price_high" : 5.59, "stock_price_low" : 5.31, "stock_price_close" : 5.37, "stock_volume" : 260800, "stock_price_adj_close" : 5.37 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d5ff"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2010-01-04", "stock_price_open" : 5.65, "stock_price_high" : 5.66, "stock_price_low" : 5.49, "stock_price_close" : 5.55, "stock_volume" : 335500, "stock_price_adj_close" : 5.55 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d600"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2010-02-03", "stock_price_open" : 4.65, "stock_price_high" : 4.69, "stock_price_low" : 4.5, "stock_price_close" : 4.55, "stock_volume" : 182100, "stock_price_adj_close" : 4.55 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d601"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2010-02-05", "stock_price_open" : 4.42, "stock_price_high" : 4.54, "stock_price_low" : 4.22, "stock_price_close" : 4.41, "stock_volume" : 194300, "stock_price_adj_close" : 4.41 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d602"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2010-02-08", "stock_price_open" : 4.42, "stock_price_high" : 4.42, "stock_price_low" : 4.21, "stock_price_close" : 4.24, "stock_volume" : 205500, "stock_price_adj_close" : 4.24 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d603"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-31", "stock_price_open" : 5.57, "stock_price_high" : 5.71, "stock_price_low" : 5.54, "stock_price_close" : 5.56, "stock_volume" : 418600, "stock_price_adj_close" : 5.56 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d604"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-30", "stock_price_open" : 5.65, "stock_price_high" : 5.67, "stock_price_low" : 5.5, "stock_price_close" : 5.57, "stock_volume" : 226400, "stock_price_adj_close" : 5.57 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d605"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-29", "stock_price_open" : 5.67, "stock_price_high" : 5.74, "stock_price_low" : 5.66, "stock_price_close" : 5.67, "stock_volume" : 115100, "stock_price_adj_close" : 5.67 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d606"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-28", "stock_price_open" : 5.81, "stock_price_high" : 5.86, "stock_price_low" : 5.63, "stock_price_close" : 5.67, "stock_volume" : 326600, "stock_price_adj_close" : 5.67 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d607"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-24", "stock_price_open" : 5.92, "stock_price_high" : 5.94, "stock_price_low" : 5.81, "stock_price_close" : 5.84, "stock_volume" : 111900, "stock_price_adj_close" : 5.84 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d608"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-23", "stock_price_open" : 5.91, "stock_price_high" : 5.99, "stock_price_low" : 5.84, "stock_price_close" : 5.87, "stock_volume" : 212000, "stock_price_adj_close" : 5.87 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d609"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-22", "stock_price_open" : 5.99, "stock_price_high" : 6.1, "stock_price_low" : 5.84, "stock_price_close" : 5.92, "stock_volume" : 307500, "stock_price_adj_close" : 5.92 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d60a"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-21", "stock_price_open" : 6, "stock_price_high" : 6.2, "stock_price_low" : 5.9, "stock_price_close" : 5.99, "stock_volume" : 257700, "stock_price_adj_close" : 5.99 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d60b"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-18", "stock_price_open" : 5.85, "stock_price_high" : 5.99, "stock_price_low" : 5.85, "stock_price_close" : 5.88, "stock_volume" : 484200, "stock_price_adj_close" : 5.88 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d60c"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-17", "stock_price_open" : 5.96, "stock_price_high" : 5.99, "stock_price_low" : 5.76, "stock_price_close" : 5.83, "stock_volume" : 506300, "stock_price_adj_close" : 5.83 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d60d"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-16", "stock_price_open" : 6.08, "stock_price_high" : 6.13, "stock_price_low" : 5.98, "stock_price_close" : 5.99, "stock_volume" : 282900, "stock_price_adj_close" : 5.99 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d60e"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-15", "stock_price_open" : 6.09, "stock_price_high" : 6.18, "stock_price_low" : 5.99, "stock_price_close" : 5.99, "stock_volume" : 753300, "stock_price_adj_close" : 5.99 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d60f"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-14", "stock_price_open" : 6.3, "stock_price_high" : 6.3, "stock_price_low" : 6.02, "stock_price_close" : 6.09, "stock_volume" : 538900, "stock_price_adj_close" : 6.09 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d610"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-11", "stock_price_open" : 6.08, "stock_price_high" : 6.25, "stock_price_low" : 6.08, "stock_price_close" : 6.19, "stock_volume" : 282800, "stock_price_adj_close" : 6.19 }
{ "_id" : ObjectId("62881dcbb09382e9bb51d611"), "exchange" : "NYSE", "stock_symbol" : "AEA", "date" : "2009-12-10", "stock_price_open" : 6.17, "stock_price_high" : 6.25, "stock_price_low" : 5.99, "stock_price_close" : 6.02, "stock_volume" : 334100, "stock_price_adj_close" : 6.02 }
Type "it" for more

> db.sts.findOne({"stock_symbol": "AEA"})
{
	"_id" : ObjectId("62881dcbb09382e9bb51d5ea"),
	"exchange" : "NYSE",
	"stock_symbol" : "AEA",
	"date" : "2010-02-04",
	"stock_price_open" : 4.55,
	"stock_price_high" : 4.69,
	"stock_price_low" : 4.39,
	"stock_price_close" : 4.42,
	"stock_volume" : 233800,
	"stock_price_adj_close" : 4.42
}

> db.sts.findOneAndDelete({"stock_symbol": "AEA"})
{
	"_id" : ObjectId("62881dcbb09382e9bb51d5ea"),
	"exchange" : "NYSE",
	"stock_symbol" : "AEA",
	"date" : "2010-02-04",
	"stock_price_open" : 4.55,
	"stock_price_high" : 4.69,
	"stock_price_low" : 4.39,
	"stock_price_close" : 4.42,
	"stock_volume" : 233800,
	"stock_price_adj_close" : 4.42
}

> db.sts.findOneAndReplace({"stock_symbol" : "AEA"} , {"exchange" : "BSE"})
{
	"_id" : ObjectId("62881dcbb09382e9bb51d5eb"),
	"exchange" : "NYSE",
	"stock_symbol" : "AEA",
	"date" : "2010-02-01",
	"stock_price_open" : 4.84,
	"stock_price_high" : 4.92,
	"stock_price_low" : 4.68,
	"stock_price_close" : 4.75,
	"stock_volume" : 194800,
	"stock_price_adj_close" : 4.75
}

> db.sts.getDB()
nysedb

> db.mycoll.dataSize()
0

> db.sts.dataSize()
174162003

> db.sts.count({"stock_symbol": "AEA"})
1291

> db.sts.deleteOne({"stock_symbol": "AEA"})
{ "acknowledged" : true, "deletedCount" : 1 }
```
