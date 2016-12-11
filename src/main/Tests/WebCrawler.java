package main.Tests;

import javax.swing.*;

public class WebCrawler extends JFrame {

    public void main(String[] args) throws Exception {
/*
        //GUI
        WebCrawlerGUI displayPanel = new WebCrawlerGUI();
        JButton okButton = new JButton("OK");
        ButtonHandler listener = new ButtonHandler();
        okButton.addActionListener(listener);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(displayPanel, BorderLayout.CENTER);
        content.add(okButton, BorderLayout.SOUTH);

        JFrame window = new JFrame("GUI Test");
        window.setContentPane(content);
        window.setSize(250,100);
        window.setLocation(100,100);
        window.setVisible(true);*/

        //Search Method
    }

    /*

    // declares the list of values to be displayed in the Max URLs to Crawl combo box
    private static final String[] MAX_URLS =
            {"50", "100", "500", "1000"};
    // caching robot disallow lists so that they don’t have to be retrieved for each URL being crawled
    private HashMap disallowListCache = new HashMap();
    // Search GUI controls.
    private JTextField MainTextField;
    private JComboBox maxUrlBox;
    private JCheckBox limitCheckBox;
    private JTextField logTextField;
    private JTextField searchTextField;
    private JCheckBox caseCheckBox;
    private JButton searchButton;
    private JLabel crawlingLabel2;
    private JLabel crawledLabel2;
    private JLabel toCrawlLabel2;
    private JProgressBar progressBar;
    private JLabel matchesLabel2;
    // Table listing search matches.
    private JTable table;
    // Flag for whether or not crawling is underway.
    private boolean crawling;
    // Matches log file print writer.
    private PrintWriter logFileWriter;
    // Constructor for Search Web Crawler.

    */

/*    //GUI
    private static class WebCrawlerGUI extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString( "WebCrawler", 20, 30 );
        }
    }

    private static class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }*/


    //GUI Method

   /* public WebCrawler() {

        // Application title.
        setTitle("WebCrawler");
        // Application window size.
        setSize(1000, 600);
        // Handle window closing events.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                closeEvent();
            }
        });

        // Set up File menu.
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem fileExitMenuItem = new JMenuItem("Exit",
                KeyEvent.VK_X);
        fileExitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeEvent();
            }
        });

        fileMenu.add(fileExitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        // Set up search panel.
        JPanel searchPanel = new JPanel();
        GridBagConstraints constraints;
        GridBagLayout layout = new GridBagLayout();
        searchPanel.setLayout(layout);

        JLabel startLabel = new JLabel("Start URL:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(startLabel, constraints);
        searchPanel.add(startLabel);
        MainTextField = new JTextField();
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        layout.setConstraints(MainTextField, constraints);
        searchPanel.add(MainTextField);
        JLabel maxLabel = new JLabel("Max URLs to Crawl:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(maxLabel, constraints);
        searchPanel.add(maxLabel);
        maxUrlBox = new JComboBox(MAX_URLS);
        maxUrlBox.setEditable(true);
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(maxUrlBox, constraints);
        searchPanel.add(maxUrlBox);
        limitCheckBox =
                new JCheckBox("Limit crawling to Start URL site");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 10, 0, 0);
        layout.setConstraints(limitCheckBox, constraints);
        searchPanel.add(limitCheckBox);
        JLabel blankLabel = new JLabel();
        constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(blankLabel, constraints);
        searchPanel.add(blankLabel);
        JLabel logLabel = new JLabel("Matches Log File:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(logLabel, constraints);
        searchPanel.add(logLabel);
        String file =
                System.getProperty("user.dir") + System.getProperty("file.separator") + "crawler.log";
        logTextField = new JTextField(file);
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        layout.setConstraints(logTextField, constraints);
        searchPanel.add(logTextField);
        JLabel searchLabel = new JLabel("Search String:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(searchLabel, constraints);
        searchPanel.add(searchLabel);
        searchTextField = new JTextField();
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 0, 0);
        constraints.gridwidth= 2;
        constraints.weightx = 1.0d;
        layout.setConstraints(searchTextField, constraints);
        searchPanel.add(searchTextField);
        caseCheckBox = new JCheckBox("Case Sensitive");
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 0, 5);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(caseCheckBox, constraints);
        searchPanel.add(caseCheckBox);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionSearch();
            }
        });
        constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 5, 5);
        layout.setConstraints(searchButton, constraints);
        searchPanel.add(searchButton);
        JSeparator separator = new JSeparator();
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 5, 5);
        layout.setConstraints(separator, constraints);
        searchPanel.add(separator);
        JLabel crawlingLabel1 = new JLabel("Crawling:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(crawlingLabel1, constraints);
        searchPanel.add(crawlingLabel1);
        crawlingLabel2 = new JLabel();
        crawlingLabel2.setFont(
                crawlingLabel2.getFont().deriveFont(Font.PLAIN));
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        layout.setConstraints(crawlingLabel2, constraints);
        searchPanel.add(crawlingLabel2);
        JLabel crawledLabel1 = new JLabel("Crawled URLs:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(crawledLabel1, constraints);
        searchPanel.add(crawledLabel1);
        crawledLabel2 = new JLabel();
        crawledLabel2.setFont(
                crawledLabel2.getFont().deriveFont(Font.PLAIN));
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        layout.setConstraints(crawledLabel2, constraints);
        searchPanel.add(crawledLabel2);
        JLabel toCrawlLabel1 = new JLabel("URLs to Crawl:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(toCrawlLabel1, constraints);
        searchPanel.add(toCrawlLabel1);
        toCrawlLabel2 = new JLabel();
        toCrawlLabel2.setFont(
                toCrawlLabel2.getFont().deriveFont(Font.PLAIN));
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        layout.setConstraints(toCrawlLabel2, constraints);
        searchPanel.add(toCrawlLabel2);
        JLabel progressLabel = new JLabel("Crawling Progress:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 0, 0);
        layout.setConstraints(progressLabel, constraints);
        searchPanel.add(progressLabel);
        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setStringPainted(true);
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 0, 5);
        layout.setConstraints(progressBar, constraints);
        searchPanel.add(progressBar);
        JLabel matchesLabel1 = new JLabel("Search Matches:");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 10, 0);
        layout.setConstraints(matchesLabel1, constraints);
        searchPanel.add(matchesLabel1);
        matchesLabel2 = new JLabel();
        matchesLabel2.setFont(
                matchesLabel2.getFont().deriveFont(Font.PLAIN));
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.insets = new Insets(5, 5, 10, 5);
        layout.setConstraints(matchesLabel2, constraints);
        searchPanel.add(matchesLabel2);
        // Set up matches table.
        table =
                new JTable(new DefaultTableModel(new Object[][]{},
                        new String[]{"URL"}) {
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;
                    }
                });
        // Set up Matches panel.
        JPanel matchesPanel = new JPanel();
        matchesPanel.setBorder(
                BorderFactory.createTitledBorder("Matches"));
        matchesPanel.setLayout(new BorderLayout());
        matchesPanel.add(new JScrollPane(table),
                BorderLayout.CENTER);
        // Add panels to display.
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(searchPanel, BorderLayout.NORTH);
        getContentPane().add(matchesPanel, BorderLayout.CENTER);
    }*/

/*    private void closeEvent() {
        System.exit(0);
    }*/

/*    private void search(final String logFile, final String startUrl, final int maxUrls, final String searchString) {
        // Start the search in a new thread.
        Thread thread = new Thread(new Runnable() {
            public void run() {
                // Show hour glass cursor while crawling is under way.
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                // Disable search controls.
                MainTextField.setEnabled(false);
                maxUrlBox.setEnabled(false);
                limitCheckBox.setEnabled(false);
                logTextField.setEnabled(false);
                searchTextField.setEnabled(false);
                caseCheckBox.setEnabled(false);
                // Switch Search button to "Stop."
                searchButton.setText("Stop");
                // Reset stats.
                table.setModel(new DefaultTableModel(new Object[][]{},
                        new String[]{"URL"}) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
                updateStats(startUrl, 0, 0, maxUrls);
                // Open matches log file.
                try {
                    logFileWriter = new PrintWriter(new FileWriter(logFile));
                } catch (Exception e) {
                    showError("Unable to open matches log file.");
                    return;
                }
                // Turn crawling flag on.
                crawling = true;
                // Perform the actual crawling.
                crawl(startUrl, maxUrls, limitCheckBox.isSelected(),
                        searchString, caseCheckBox.isSelected());
                // Turn crawling flag off.
                crawling = false;
                // Close matches log file.
                try {
                    logFileWriter.close();
                } catch (Exception e) {
                    showError("Unable to close matches log file.");
                }
                // Mark search as done.
                crawlingLabel2.setText("Done");
                // Enable search controls.
                MainTextField.setEnabled(true);
                maxUrlBox.setEnabled(true);
                limitCheckBox.setEnabled(true);
                logTextField.setEnabled(true);
                searchTextField.setEnabled(true);
                caseCheckBox.setEnabled(true);
                // Switch search button back to "Search."
                searchButton.setText("Search");
                // Return to default cursor.
                setCursor(Cursor.getDefaultCursor());
                // Show message if search string not found.
                if (table.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(WebCrawlerTest.this,
                            "Your Search String was not found. Please try another.",
                            "Search String Not Found",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        thread.start();
    }*/

}





